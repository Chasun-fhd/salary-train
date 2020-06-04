package org.jasmine;

import java.lang.reflect.Field;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/3
 * @description:
 **/
public class ReflectionTest {

    private final String str = "ss";
    private final String str2;

    public ReflectionTest() {
        this.str2 = "bb";
    }

    public static void main(String[] args)  throws Exception{
        ReflectionTest test = new ReflectionTest();
        Field field = ReflectionTest.class.getDeclaredField("str");
        field.setAccessible(true);
        field.set(test, "ss1");

        System.out.println(test.str);

        Field field1 = ReflectionTest.class.getDeclaredField("str2");
        field1.setAccessible(true);
        field1.set(test, "bb1");

        System.out.println(test.str2);

    }
}
