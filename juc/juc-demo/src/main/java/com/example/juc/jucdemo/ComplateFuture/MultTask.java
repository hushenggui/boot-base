package com.example.juc.jucdemo.ComplateFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: boot-base
 * @description:  多任务执行
 * @author: hushenggui
 * @create: 2022-06-15 10:32
 **/
@Slf4j
public class MultTask {

  public static void main(String[] args) {
    List<CompletableFuture<Void>> tasksFutures = new ArrayList<>();
    Random random = new Random(100);
    tasksFutures.add(
        CompletableFuture.runAsync(() -> {
        try {
          System.out.println(random.nextInt());
        } catch (Exception e) {
          e.printStackTrace();
          log.error(e.getMessage(), e);
        }
      })
    );
    tasksFutures.add(
        CompletableFuture.runAsync(() -> {
          try {
            System.out.println(random.nextInt());
          } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
          }
        })
    );

    tasksFutures.add(
        CompletableFuture.runAsync(() -> {
          try {
            System.out.println(random.nextInt());
          } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
          }
        })
    );
    CompletableFuture.allOf(tasksFutures.toArray(new CompletableFuture[0])).join();
  }

}
