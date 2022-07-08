package com.example.juc.jucdemo.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-06-12 20:50
 **/
public class LamdaService {
  public static void main(String[] args) throws InterruptedException {
    /**
     * 结果如下：
     * [9934, 9938, 9940, 9931, 9935, 9933, 9944, 9942, 9939, 9940]
     * [10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
     */
    demo(
        () -> new int[10],
        (array) -> array.length,
        (array, index) -> array[index]++,
        (array) -> System.out.println(Arrays.toString(array))
    );
    TimeUnit.SECONDS.sleep(1);
    demo(
        () -> new AtomicIntegerArray(10),
        (array) -> array.length(),
        (array, index) -> array.getAndIncrement(index),
        (array) -> System.out.println(array)
    );
  }

  /**
   *
   * @param arraySupplier  提供者 无中生有-> ()->结果
   * @param lengthFun      函数 一个参数一个结果 （参数） -> 结果 ， BigFunction (参数1，参数2) -> 结果
   * @param putConsumer    消费者 一个参数没结果不需要返回
   * @param printConsumer  消费者 （参数1，参数2）
   * @param <T>
   */
  private static <T> void demo(
      Supplier<T> arraySupplier,
      Function<T, Integer> lengthFun,
      BiConsumer<T, Integer> putConsumer,
      Consumer<T> printConsumer) {
    ArrayList<Thread> ts = new ArrayList<>(); // 创建集合
    T array = arraySupplier.get(); // 获取数组
    int length = lengthFun.apply(array); // 获取数组的长度
    for(int i = 0; i < length; i++) {
      ts.add(new Thread(() -> {
        for (int j = 0; j < 10000; j++) {
          putConsumer.accept(array, j % length);
        }
      }));
    }
    ts.forEach(Thread::start);
    ts.forEach((thread) -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    printConsumer.accept(array);
  }

}
