package com.husg.zkexclusivelock.service;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class WatcherDemo implements Watcher {
    static ZooKeeper zooKeeper;
    static {
        try {
            zooKeeper = new ZooKeeper(Constants.zkServer, 4000, new WatcherDemo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println("eventType:"+event.getType());
        if(event.getType()==Event.EventType.NodeDataChanged){
            try {
                zooKeeper.exists(event.getPath(),true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String path = "/watcher";
        if(zooKeeper.exists(path,false)==null) {
            zooKeeper.create("/watcher", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        Thread.sleep(1000);
        System.out.println("-----------");
        //true表示使用zookeeper实例中配置的watcher
        Stat stat=zooKeeper.exists(path,true);
        System.in.read();
    }
}