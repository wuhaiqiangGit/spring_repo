package com.whq.mvc.framework.zk.api;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 异步创建节点
 * @Author: whq
 * @Date: 2021/9/6 16:35
 */
public class CreateNodeASync implements Watcher {

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            zooKeeper.create("/node_1", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT, new MyStringCallback(), "传输的数据");
        }
    }

    private static class MyStringCallback implements AsyncCallback.StringCallback {

        /**
         * @param rc   create操作的结果码
         * @param path 我们要创建的节点 路径， 如: "/abc"
         * @param ctx  一步创建时，传递的上下文
         * @param name 最终创建了的 节点路径; 如: "/abc10000000001" 当创建的是有序节点时，path与name不一致
         */
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.printf("进入MyStringCallBack回调");
            StringBuilder sb = new StringBuilder(32);
            sb.append("rc = ").append(rc).append("\n");
            sb.append("path = ").append(path).append("\n");
            sb.append("ctx = ").append(ctx).append("\n");
            sb.append("name = ").append(name);
            System.out.printf("sb: %s\n", sb.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper("192.168.1.108:2181", 5000, new CreateNodeASync());
        TimeUnit.SECONDS.sleep(10);
    }
}
