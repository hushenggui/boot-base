package com.example.juc.jucdemo.ComplateFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @program: boot-base
 * @description: 示例
 *
 *  从Java8开始引入了CompletableFuture，它是Future的功能增强版，减少阻塞和轮询，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
 *  CompleetableFuture优点
 * 1. 异步任务结束时，会自动回调某个对象的方法；
 * 2. 异步任务出错时，会自动回调某个对象的方法；
 * 3. 主线程设置好回调后，不再关心异步任务的执行，异步任务之间可以顺序执行
 *
 *
 * @author: hushenggui
 * @create: 2023-02-21 09:31
 **/
public class CompletableFutureUseDemo {

  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    try {
      CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread().getName() + "come in");
        int result = ThreadLocalRandom.current().nextInt(10);
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("-----1秒钟出结果为：" + result);
        if(result > 5){
          int i = 10 /0;
        }
        return result;
      },executorService).whenComplete((v,e) -> {
        if(e == null){
          System.out.println("结算完成，结果为："+v);
        }
      }).exceptionally(e -> {
        e.printStackTrace();
        System.out.println("发生异常:"+e.getCause()+"\t"+e.getMessage());
        return null;
      });
      System.out.println(Thread.currentThread().getName()+"先去忙其他任务");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
    // 主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭 : 暂停 3 秒钟线程
    // TimeUnit.SECONDS.sleep(3);

    //当一个线程依赖另一个线程时用 thenApply 方法来把这两个线程串行化,
    CompletableFuture.supplyAsync(() -> {
      //暂停几秒钟线程
      try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
      System.out.println("111");
      return 1024;
    }).thenApply(f -> {
      System.out.println("222");
      return f + 1;
    }).thenApply(f -> {
      //int age = 10/0; // 异常情况：那步出错就停在那步。
      System.out.println("333");
      return f + 1;
    }).whenCompleteAsync((v,e) -> {
      System.out.println("*****v: "+v);
    }).exceptionally(e -> {
      e.printStackTrace();
      return null;
    });

    System.out.println("-----主线程结束，END");

    //handle 类似于thenApply，但是有异常的话仍然可以往下走一步。
    //当一个线程依赖另一个线程时用 handle 方法来把这两个线程串行化,
    // 异常情况：有异常也可以往下一步走，根据带的异常参数可以进一步处理
    CompletableFuture.supplyAsync(() -> {
      //暂停几秒钟线程
      try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
      System.out.println("111");
      return 1024;
    }).handle((f,e) -> {
      int age = 10/0;//异常语句
      System.out.println("222");
      return f + 1;
    }).handle((f,e) -> {
      System.out.println("333");
      return f + 1;
    }).whenCompleteAsync((v,e) -> {
      System.out.println("*****v: "+v);
    }).exceptionally(e -> {
      e.printStackTrace();
      return null;
    });

    System.out.println("-----主线程结束，END");

    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
    try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }



    /**
     *   thenCombine
     *   ○ 两个CompletionStage任务都完成后，最终能把两个任务的结果一起交给thenCOmbine来处理
     *   ○ 先完成的先等着，等待其它分支任务
     */
    CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + "\t" + "---come in ");
      return 10;
    });

    CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + "\t" + "---come in ");
      return 20;
    });

    CompletableFuture<Integer> thenCombineResult = completableFuture1.thenCombine(completableFuture2, (x, y) -> {
      System.out.println(Thread.currentThread().getName() + "\t" + "---come in ");
      return x + y;
    });

    System.out.println(thenCombineResult.get());



  }
  public static void future1() throws Exception{
    CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + "come in");
      int result = ThreadLocalRandom.current().nextInt(10);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("-----1秒钟出结果为：" + result);
      return result;
    });
    System.out.println(Thread.currentThread().getName()+"先去忙其他任务");
    System.out.println(integerCompletableFuture.get());
  }

}
