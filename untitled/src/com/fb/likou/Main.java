package com.fb.likou;

import java.io.IOException;
import java.util.HashMap;

public class Main<K,V> {

    private HashMap<K,V> map;

    public <T> T getO(T t) {
        return t;
    }



    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        map.put(s.charAt(left),left);
        int max = 1;
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                max = Math.max(max,right - left + 1);
                map.put(s.charAt(right),right);
            }else {
                while (s.charAt(left) != s.charAt(right)) {
                    map.remove(s.charAt(left++));
                }
                map.remove(s.charAt(left++));
                map.put(s.charAt(right),right);
            }
            right++;
        }
        return max;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0;i < matrix.length;i++) {
            int x = search(matrix[i],target,0,matrix[i].length - 1);
            if (x > 0){
                return true;
            }
        }
        return false;
    }
    public static int search(int[] num,int target,int left,int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        int x = num[mid];
        if (x == target) {
            return mid;
        }else if (x < target) {
            return search(num,target,mid + 1,right);
        }else {
            return search(num,target,left,mid - 1);
        }
    }


    public static void main(String[] args) throws IOException {
        searchMatrix(new int[][]{{-1,3}},3);
    }

    public void ge() {

    }

}
