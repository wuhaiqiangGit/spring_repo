package com.whq.mvc.framework.zk.api;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 同步创建节点
 * @Author: whq
 * @Date: 2021/9/6 17:05
 */
public class CreateNodeSync implements Watcher {

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.printf("线程：%s 监听到了：%s\n",Thread.currentThread().getName(),watchedEvent.toString());
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            try {
                String path = zooKeeper.create("sync_node", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
                System.out.printf("新创建node path: %s\n", path);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper("192.168.1.108:2181",5000,new CreateNodeSync());
        TimeUnit.SECONDS.sleep(10);
    }
}
