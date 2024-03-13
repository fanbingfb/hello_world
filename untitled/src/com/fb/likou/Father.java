package com.fb.likou;

import org.jetbrains.annotations.Nullable;

public abstract class Father {

    private static int defeatGetNotifyId(int id) {
        return id * 10;
    }


    /**
     *
     * @param id    要进行加密的id
     * @param father    想用加密算法的实现类
     * @return
     */
    public static int getNotifyId(int id,@Nullable Father father) {
        if (father == null) {
            return defeatGetNotifyId(id);
        }
        return father.getNotifyId(id);
    }

    public abstract int getNotifyId(int id);

    static class Child extends Father{
        @Override
        public int getNotifyId(int id) {
            return id - 100;
        }
    }

}
