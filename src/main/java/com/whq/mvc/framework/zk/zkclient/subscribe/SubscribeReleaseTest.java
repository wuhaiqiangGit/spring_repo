package com.whq.mvc.framework.zk.zkclient.subscribe;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkInterruptedException;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 发布订阅测试代码
 * @Author: whq
 * @Date: 2021/9/7 10:52
 */
public class SubscribeReleaseTest {
    private static final int SIZE = 5;
    private static final String IP_PORT = "192.168.1.108:2181";
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CONNECT_TIMEOUT = 10000;
    private static final String CONFIG_NODE_PATH = "/config";
    private static final String SERVER_NODE_PATH = "/servers";
    private static final String COMMAND_NODE_PATH = "/command";
    private static ZkClient managerServerClient;
    private static ManageServer manageServer;

    private static List<ZkClient> zkClients = new ArrayList<>(16);
    private static List<WorkerServer> workerServers = new ArrayList<>(16);

    public static void main(String[] args) {
        try {
            zkClients.clear();
            workerServers.clear();
            managerServerClient = new ZkClient(IP_PORT, SESSION_TIMEOUT, CONNECT_TIMEOUT, new BytesPushThroughSerializer());
            manageServer = new ManageServer(managerServerClient, SERVER_NODE_PATH, COMMAND_NODE_PATH, CONFIG_NODE_PATH);
            manageServer.start();
            for (int i = 0; i < SIZE; i++) {
                WorkerServerParamModel wsParamModel = new WorkerServerParamModel();
                wsParamModel.setServerId(i);
                wsParamModel.setServerName("worker" + i);
                ConfigPOJO initConfig = new ConfigPOJO();
                initConfig.setAgeConfig(10 + i);
                initConfig.setGenderConfig("性别" + i);
                initConfig.setNameConfig("姓名" + i);
                initConfig.setMottoConfig("座右铭" + i);

                ZkClient zkClient = new ZkClient(IP_PORT, SESSION_TIMEOUT, CONNECT_TIMEOUT,
                        new BytesPushThroughSerializer());
                zkClients.add(zkClient);
                WorkerServer workerServer = new WorkerServer(zkClient, wsParamModel, CONFIG_NODE_PATH,
                        SERVER_NODE_PATH, initConfig);
                workerServers.add(workerServer);
                workerServer.start();
            }
            System.out.printf("主线程等待一段时间~\n");
            TimeUnit.SECONDS.sleep(180);
        } catch (ZkInterruptedException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("开始退出\n");
            for (WorkerServer workerServer : workerServers) {
                workerServer.stop();
            }
            for (ZkClient zkClient : zkClients) {
                zkClient.close();
            }
            manageServer.stop();
            managerServerClient.close();
        }
    }
}
