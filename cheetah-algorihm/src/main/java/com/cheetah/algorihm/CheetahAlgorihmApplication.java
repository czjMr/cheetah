package com.cheetah.algorihm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CheetahAlgorihmApplication {

    public static void main(String[] args){

        int[] nums = new int[]{100,4,200,1,3,2};
        longestConsecutive(nums);
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<StrBean> numListMap = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            numListMap.add(new StrBean(sortStr, str));
        }
        Map<String, List<String>> collect = numListMap.stream().collect(Collectors.groupingBy(StrBean::getSortStr, Collectors.mapping(StrBean::getStr, Collectors.toList())));
        return new ArrayList(collect.values());


    }

    private static class StrBean {
        private String sortStr;
        private String Str;

        public StrBean(String sortStr, String str) {
            this.sortStr = sortStr;
            Str = str;
        }

        public String getSortStr() {
            return sortStr;
        }

        public void setSortStr(String sortStr) {
            this.sortStr = sortStr;
        }

        public String getStr() {
            return Str;
        }

        public void setStr(String str) {
            Str = str;
        }
    }


    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> countList = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int count = 1;
            if (nums[1]-nums[i-1] == 1) {
                count++;
            } else {
                countList.add(count);
                count = 1;
            }
            countList.add(count);
        }
        System.out.println(countList);
        return countList.stream().flatMapToInt(IntStream::of).max().getAsInt();
    }


}
