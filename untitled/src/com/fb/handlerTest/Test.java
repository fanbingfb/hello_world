package com.fb.handlerTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    Handler handler;

    Handler handler2;

    public static void main(String[] args) {
        Test test = new Test();
        test.testHandler();
    }
    public void testHandler() {
        new Thread(() -> {
            try {

                Looper.prepare();
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        System.out.println("ThreadName:" + Thread.currentThread().getName() + "messsage" + msg.content);
                    }
                };

                handler2 = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        System.out.println("ThreadName:" + Thread.currentThread().getName() + "messsage2" + msg.content);
                    }
                };
                for (;;) {
                    Thread.sleep(1000);
                    Looper.loop();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {

                for (;;) {
                    Thread.sleep(1000);
                    handler.sendMessage(new Message("qwe"));
                    handler2.sendMessage(new Message("ert"));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    public abstract class Handler {

        private Looper mLooper;
        public Handler() {
            mLooper = Looper.MyLooper();
        }

        public void sendMessage(Message msg) {
            Looper looper = mLooper;
            msg.target = this;
            looper.queue.push(msg);
        }

        public abstract void handleMessage(Message msg);


    }

    class Message {

        Handler target;
        String content;

        public Message(String content) {
            this.content = content;
        }
    }

     static class BlockQueue {
        private BlockingQueue<Message> queue;

        public BlockQueue() {
            queue = new LinkedBlockingQueue();
        }

        public Message take(){
            try {
                return queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void push(Message msg){
            try {
                queue.put(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Looper {
        private BlockQueue queue = new BlockQueue();
        private static ThreadLocal<Looper> threadLocal = new ThreadLocal<>();

        public static void prepare() {
            threadLocal.set(new Looper());
        }
        public static Looper MyLooper() {
            return threadLocal.get();
        }

        public static void loop() {
            Looper looper = MyLooper();
            BlockQueue queue = looper.queue;
            for (;;) {
                Message msg =queue.take();
                msg.target.handleMessage(msg);
            }
        }
    }
}
