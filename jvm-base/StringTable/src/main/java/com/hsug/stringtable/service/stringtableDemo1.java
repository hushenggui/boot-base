package com.hsug.stringtable.service;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-03-05 15:56
 **/
public class stringtableDemo1 {

  public int i = 0;
  public Integer b = 0;

  public static void main(String[] args) {
//"a" "b" 被放入串池中，str则存在于堆内存之中
  /*  String str = new String("ab");
    //调用str的intern方法，这时串池中没有"ab"，则会将该字符串对象放入到串池中，此时堆内存与串池中的"ab"是同一个对象
    String st2 = str.intern();
    //给str3赋值，因为此时串池中已有"ab"，则直接将串池中的内容返回
    String str3 = "ab";
    //因为堆内存与串池中的"ab"是同一个对象，所以以下两条语句打印的都为true
    System.out.println(str == st2);
    System.out.println(st2 == str3);*/
    stringtableDemo1 stringtableDemo1 = new stringtableDemo1();
    System.out.println(stringtableDemo1.i == stringtableDemo1.b);


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String dateTimeStr= "2022-04-01 12:00:00";
    LocalDateTime apply = LocalDateTime.parse(dateTimeStr, dtf);
    LocalDateTime localDateTime = LocalDateTime.now();
    Duration duration = Duration.between(apply, LocalDateTime.now());
    System.out.println(duration.toDays());
    System.out.println(duration.toHours());
    System.out.println(localDateTime.format(dtf));

    LocalDateTime localDateTime1 = LocalDateTime.parse(dateTimeStr, dtf);

 /*   Runnable r = () -> {

    };
    Thread thread = new Thread(){
      @Override
      public void run(){

      }
    };
    thread.start();*/

  }

}
