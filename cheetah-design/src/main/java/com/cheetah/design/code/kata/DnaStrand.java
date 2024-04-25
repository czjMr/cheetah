package com.cheetah.design.code.kata;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DnaStrand {

    public static String makeComplement(String dna) {
        //Your code
         return Stream.of(dna.split("")).map(item -> item.equals("T")?"A"
                 :item.equals("C")?"G"
                 :item.equals("A")?"T"
                 :item.equals("G")?"C":item).collect(Collectors.joining());


    }


    public static String makeComplementlever(String dna) {
        dna = dna.replaceAll("A","Z");
        dna = dna.replaceAll("T","A");
        dna = dna.replaceAll("Z","T");
        dna = dna.replaceAll("C","Z");
        dna = dna.replaceAll("G","C");
        dna = dna.replaceAll("Z","G");
        return dna;
    }

    public static void main(String[] args) {
//        char t = 'T';
//
//        int[] ints = new int[]{1,2};
//        System.out.println(makeComplement("TAACG"));


        System.out.println(Integer.MIN_VALUE+"");
        System.out.println(Integer.MAX_VALUE+"");


    }


//        @Test
//        public void test01() {
//            Assert.assertEquals("1*2 + 1*2", OutOutPutExExpress(new int[]{1,2},new int[]{1,2}));
//            Assert.assertEquals("-2147483648*1 + -1*2", OutOutPutExExpress(new int[]{Integer.MIN_VALUE,1},new int[]{-1,2}));
//            Assert.assertEquals("2147483647*1 + 1*2", OutOutPutExExpress(new int[]{Integer.MAX_VALUE,1},new int[]{1,2}));
//            Assert.assertEquals("-2147483648*2147483647 + 1*2", OutOutPutExExpress(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE},new int[]{1,2}));
//            Assert.assertEquals("-2147483648*-2147483648 + 1*2", OutOutPutExExpress(new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE},new int[]{1,2}));
//            Assert.assertEquals("2147483647*2147483647 + 1*2", OutOutPutExExpress(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE},new int[]{1,2}));
//        }







        @Test
        public void test02() {
            assertEquals("TAACG", DnaStrand.makeComplement("ATTGC"));
        }
        @Test
        public void test03() {
            assertEquals("CATA", DnaStrand.makeComplement("GTAT"));
        }
    }
