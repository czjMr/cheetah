package com.cheetah.algorihm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.util.comparator.Comparators;

public class CheetahAlgorihmApplication {

    public static void main(String[] args){

//        int[] nums = new int[]{100,4,200,1,3,2};
//        longestConsecutive(nums);
        gimmeTheLetters("a-z");
        encode("Prespecialized");
        top3("'a 'A 'a' a'A' a'a'!");
        top3("  //wont! won't, won't..");
        top3("""
                 In a village of La Mancha, the name of which I have no desire to call to
                 mind, there lived not long since one of those gentlemen that keep a lance
                 in the lance-rack, an old buckler, a lean hack, and a greyhound for
                 coursing. An olla of rather more beef than mutton, a salad on most
                 nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
                 on Sundays, made away with three-quarters of his income.
               """
        );



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


    public static List<Integer> findAnagrams(String s, String p) {







        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < s.length()-p.length(); i++) {
            if(Arrays.asList(p.toCharArray()).contains(s.toCharArray()[i])) {
                continue;
            }
            String substring = s.substring(i, i + p.length());
            char[] chars = substring.toCharArray();
            char[] chars1 = p.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            if(Arrays.equals(chars,chars1)) {
                indexs.add(i);
            }
        }
        return indexs;
    }


    static String encode(String word){
        Map<Character,Object> hashMap = new HashMap<>();
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(hashMap.containsKey(chars[i])) {
                word = word.replace(String.valueOf(chars[i]),")");
            }
            hashMap.put(chars[i], null);
        }

        char[] chars1 = word.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (!String.valueOf(chars1[i]).equals(")")) {
                word = word.replace(String.valueOf(chars[i]),"(");
            }
        }
        return word;
    }

    public static List<String> top3(String s) {
        // Your code here 编写一个函数，
//        s = s.replace(",","").replace("..","").replace("!","").replace(".","").replace(" ' ","   ").replace("'''","  ").replace(" '","   ");
//        s = s.replace("\n","").replace("\r","").replace("\r\n","").replace("//","").trim().toLowerCase();

        s = s.replace("[A-z']+(?=[ ]+|$)/g","");
        s = s.trim().toLowerCase();
        if(s.trim().length()<1) {
            return new ArrayList<>();
        }
        String[] wordsArray = s.split("\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String value : wordsArray) {
            map.put(value, Objects.nonNull(map.get(value)) ? map.get(value) + 1 : 1);
        }
        return map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());


    }

    public static String gimmeTheLetters(String s){

        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String[] array = s.split("-");

        if(lowercase.contains(array[0])) {
            return lowercase.substring(lowercase.indexOf(array[0]),lowercase.indexOf(array[1])+1);
        }

        if(capital.contains(array[0])) {
            return capital.substring(lowercase.indexOf(array[0]),capital.indexOf(array[1])+1);
        }
        return "";





    }

    public static String gimmeTheLettersBest(String s) {
        return IntStream.rangeClosed(s.charAt(0), s.charAt(2))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String stripComments(String text, String[] commentSymbols) {

        return "";
    }


}
