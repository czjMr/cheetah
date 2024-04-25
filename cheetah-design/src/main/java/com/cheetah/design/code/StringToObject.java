package com.cheetah.design.code;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.util.StringUtils;

public class StringToObject {

    public static Map<String, String> getMap(String str) {
        str = str.substring(str.indexOf("[") + 1, str.length() - 1);
        char[] array = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        String temp = null;
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if ('[' == c) {
                stack.push(c);
                sb.append(c);
            } else if (']' == c) {
                stack.pop();
                sb.append(c);
            } else if (i == array.length - 1) {
                sb.append(c);
                map.put(temp, sb.toString().trim());
                temp = null;
                sb.delete(0, sb.length());
            } else {
                if (stack.isEmpty()) {
                    if ('=' == c || ',' == c) {
                        if (StringUtils.isEmpty(temp)) {
                            temp = sb.toString().trim();
                        } else {
                            map.put(temp, sb.toString().trim());
                            temp = null;
                        }
                        sb.delete(0, sb.length());
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            }

        }
        return map;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T getObject(Map<String, String> map, Class<T> t) throws Exception {
        map.put("partners","[TransPartnerDTO[partnerRole=CAPITAL,memberNo=9cc2ef1b34a9458ba0a8065eb93090dc,memberNoType=2,feeCode=PRINCIPAL,amount=1154.600000], TransPartnerDTO[partnerRole=CAPITAL,memberNo=9cc2ef1b34a9458ba0a8065eb93090dc,memberNoType=2,feeCode=INTEREST,amount=13.510000], TransPartnerDTO[partnerRole=PAYER,memberNo=28e0a6458ddc4e0c9be3a942c699266c,memberNoType=3,feeCode=PRINCIPAL,amount=1154.600000], TransPartnerDTO[partnerRole=PAYER,memberNo=28e0a6458ddc4e0c9be3a942c699266c,memberNoType=3,feeCode=INTEREST,amount=13.510000]]]");
        T instance = t.newInstance();
        Set<Entry<String, String>> set = map.entrySet();
        for (Entry<String, String> entry : set) {
            String key = entry.getKey();
            String value = entry.getValue();
            Field field = instance.getClass().getDeclaredField(key);
            System.out.println(field.getGenericType().toString());
            field.setAccessible(true);
            if ("null".equals(value)) {
                continue;
            }
            if (field.getGenericType().toString().equals("class java.lang.String")) {
                field.set(instance, value);
            }
            if (field.getGenericType().toString().equals("class java.lang.Integer")) {
                field.set(instance, Integer.parseInt(value));
            }
            if (field.getGenericType().toString().equals("long")) {
                field.set(instance, Long.parseLong(value));
            }
            if (field.getGenericType().toString().equals("int")) {
                field.set(instance, Integer.parseInt(value));
            }
            if (field.getGenericType().toString().equals("class java.util.Date")) {
                SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                field.set(instance, format.parse(value));
            }
            if (field.getGenericType().toString().equals("java.util.List<java.lang.String>")) {
                value = value.substring(1, value.length() - 1);
                field.set(instance, Arrays.asList(value.split(",")));
            } else if (field.getGenericType().toString().startsWith("java.util.List")) {

                Stack<Character> stack = new Stack<Character>();
                ArrayList<String> list = new ArrayList<String>();
                value = value.substring(value.indexOf("[") + 1, value.length() - 1);
                char[] array = value.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (char c : array) {
                    if ('[' == c) {
                        stack.push(c);
                        sb.append(c);
                    } else if (']' == c) {
                        stack.pop();
                        sb.append(c);
                        if (stack.isEmpty()) {
                            list.add(sb.toString().trim());
                            sb.delete(0, sb.length());
                        }
                    } else {
                        sb.append(c);
                    }
                }

                Type type = field.getGenericType();
                ParameterizedType pt = (ParameterizedType) type;
                Class tp = (Class) pt.getActualTypeArguments()[0];
                List lot = createListOfType(tp);
                for (int i = 0; i < list.size(); i++) {
                    Map<String, String> mm = getMap(list.get(i));
                    Object object = getObject(mm, tp);
                    lot.add(object);
                }

                field.set(instance, lot);
            }

        }
        return instance;
    }

    public static <T> List<T> createListOfType(Class<T> type) {
        return new ArrayList<T>();
    }


    public static void main(String[] args) throws Exception {

        String str = "CreditTransDTO[trackingNo=GMJOB200102001729002370503002503,transCode=11120300,memberNo=3e6bfcd5cb5a4c0ba6656fa8c94c0341,loanNo=GMLOC19012610361903208,bizOrderNo=GMJOB200102001728009110503002123,bizSysCode=503,productCode=5561,businessGroupCode=MJ,capitalCode=0002,biddingNo=GMBEC19012610412891001006,totalAmount=1168.110000,currency=CNY,businessDate=Thu Jan 02 00:00:00 CST 2020,accountingDate=Thu Jan 02 00:00:00 CST 2020,accBizDate=null,ageAccount=0,preAgeAccount=0,isOffBalance=false,owningBranch=000000000001,partners=[TransPartnerDTO[partnerRole=CAPITAL,memberNo=9cc2ef1b34a9458ba0a8065eb93090dc,memberNoType=2,feeCode=PRINCIPAL,amount=1154.600000], TransPartnerDTO[partnerRole=CAPITAL,memberNo=9cc2ef1b34a9458ba0a8065eb93090dc,memberNoType=2,feeCode=INTEREST,amount=13.510000], TransPartnerDTO[partnerRole=PAYER,memberNo=28e0a6458ddc4e0c9be3a942c699266c,memberNoType=3,feeCode=PRINCIPAL,amount=1154.600000], TransPartnerDTO[partnerRole=PAYER,memberNo=28e0a6458ddc4e0c9be3a942c699266c,memberNoType=3,feeCode=INTEREST,amount=13.510000]]]";

        CreditTransDTO object = getObject(getMap(str), CreditTransDTO.class);

        System.out.println(object);
    }

}