package com.husg.zkexclusivelock.service;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;


public class ConnectionDemo {

    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch=new CountDownLatch(1);
            ZooKeeper zooKeeper= new ZooKeeper(Constants.zkServer , 4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            if(Event.KeeperState.SyncConnected==event.getState()){
                                //如果收到了服务端的响应事件，连接成功
                                System.out.println("zk 连接成功 ======================");
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());
            zooKeeper.create("/runoob","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
