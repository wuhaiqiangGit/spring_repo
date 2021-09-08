package com.whq.mvc.framework.zk.api;

import lombok.SneakyThrows;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 获取子节点
 * @Author: whq
 * @Date: 2021/9/6 17:23
 */
public class ChildrenListSync {

    private static ZooKeeper zooKeeper;

    private static class MyWatch implements Watcher{

        @SneakyThrows
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.printf("线程：%s 监听到了：%s\n",Thread.currentThread().getName(),watchedEvent.toString());
            if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
                List<String> children = zooKeeper.getChildren("/node_1", false);
                for (int i = 0; i < children.size(); i++) {
                    System.out.printf("%s\n",children.get(i));
                }
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        zooKeeper = new ZooKeeper("192.168.1.108:2181",5000,new MyWatch());
        TimeUnit.SECONDS.sleep(10);
    }
}
