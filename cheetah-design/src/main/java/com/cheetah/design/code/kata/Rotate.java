package com.cheetah.design.code.kata;

public class Rotate {



        public static  void rotate(int[] nums, int k) {
            int length = nums.length;
            k %= length;
            reverse(nums, 0, length - 1);//先反转全部的元素
            reverse(nums, 0, k - 1);//在反转前k个元素
            reverse(nums, k, length - 1);//接着反转剩余的
        }

        //把数组中从[start，end]之间的元素两两交换,也就是反转
        public static void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }



    public static void main(String[] args) {

        int[] ints = {1, 666, 3};

        rotate(ints,2);
    }

}
