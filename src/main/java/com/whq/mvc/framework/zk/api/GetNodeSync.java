package com.whq.mvc.framework.zk.api;

import lombok.SneakyThrows;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.TimeUnit;

/** 
 * @Description: 获取节点数据 
 * @Author: whq
 * @Date: 2021/9/6 20:47
 */
public class GetNodeSync implements Watcher {

    private static ZooKeeper zooKeeper;

    @SneakyThrows
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            Stat stat = new Stat();
            byte[] data = zooKeeper.getData("/node_1", false, stat);
            System.out.printf("data: %s\n", new String(data));
            System.out.printf("stat: %s\n", stat);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        zooKeeper = new ZooKeeper("192.168.1.108:2181",5000,new GetNodeSync());
        TimeUnit.SECONDS.sleep(10);
    }
}
