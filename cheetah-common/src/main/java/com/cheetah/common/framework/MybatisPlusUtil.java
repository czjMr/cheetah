//package com.cheetah.common.framework;
//
//import java.beans.PropertyDescriptor;
//import java.lang.invoke.CallSite;
//import java.lang.invoke.LambdaMetafactory;
//import java.lang.invoke.MethodHandles;
//import java.lang.invoke.MethodType;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//
//public class MybatisPlusUtil {
//
//
//    private static final int FLAG_SERIALIZABLE = 1;
//
//    @SuppressWarnings(value={"unchecked", "rawtypes"})
//    private static  <T,R> SFunction<T,?> getSFunction(Class methodTypeClazz,String methodName,Class<T> clazz) {
//        SFunction<T,?> function = null;
//        final MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodType methodType = MethodType.methodType(methodTypeClazz,clazz);
//        final CallSite site;
//        try {
//            site = LambdaMetafactory.altMetafactory(lookup,
//                    "invoke",
//                    MethodType.methodType(SFunction.class),
//                    methodType,
//                    lookup.findVirtual(clazz, methodName, MethodType.methodType(methodTypeClazz)),
//                    methodType,FLAG_SERIALIZABLE);
//            function = (SFunction<T,R>) site.getTarget().invokeExact();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return function;
//    }
//
//
//    private <T> HashMap<SFunction<T, ?>, Object> functionMap(Object object, Class<T> clazz) {
//        HashMap<SFunction<T, ?>, Object> functionMap = new HashMap<>();
//        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(clazz);
//        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//            System.out.println(propertyDescriptor);
//            Method readMethod = propertyDescriptor.getReadMethod();
//            SFunction<T, ?> function = getSFunction(propertyDescriptor.getPropertyType(),readMethod.getName(), clazz);
//            System.out.println(readMethod.getName());
//            System.out.println(BeanUtil.getFieldValue(object, propertyDescriptor.getName()));
//            functionMap.put(function, BeanUtil.getFieldValue(object, propertyDescriptor.getName()));
//        }
//        return functionMap;
//    }
//
//}
