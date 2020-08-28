package com.techproed;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day08_BeforeAfterClass {
   @BeforeClass
   public static void setUp(){
       System.out.println("setUp calisti");
   }
   @Test
   public void test1(){
       System.out.println("Test1 calisti");
   }
    @Test
    public void test2(){
        System.out.println("Test2 calisti");
    }
   @AfterClass
   public static void tearDown(){
       System.out.println("tearDown calisti");
   }

}
