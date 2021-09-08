package com.whq.mvc.framework.zk.zkclient.subscribe;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;

/**
 * @Description: 集群中workerServer实现
 * @Author: whq
 * @Date: 2021/9/6 20:52
 */
public class WorkerServer {

    private ZkClient zkClient;
    //当前节点配置信息
    private WorkerServerParamModel currentWorkerServer;
    //config节点路径
    private String configNodePath;
    //servers节点路径
    private String serversNodePath;
    //config节点初始化数据
    private ConfigPOJO configPOJOData;
    //config节点信息更新监听器
    private IZkDataListener configNodeDataListener;

    public WorkerServer(ZkClient zkClient, WorkerServerParamModel currentWorkerServer, String configNodePath, String serversNodePath,
                        ConfigPOJO configPOJOData) {
        this.zkClient = zkClient;
        this.currentWorkerServer = currentWorkerServer;
        this.configNodePath = configNodePath;
        this.serversNodePath = serversNodePath;
        this.configPOJOData = configPOJOData;
        this.configNodeDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                String jsonString = new String((byte[]) data);
                //最新的配置文件信息
                ConfigPOJO newestConfigNodeData = JSON.parseObject(jsonString, ConfigPOJO.class);
                updateConfigData(newestConfigNodeData);
                System.out.printf("%s 监听到了config节点数据变化，变化后数据为：%s\n", currentWorkerServer.getServerName(), jsonString);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }
        };
    }

    /**
     * @Description: 启动时方法
     * @Author: whq
     * @Date: 2021/9/6 21:16
     */
    public void start() {
        System.out.printf("%s 节点开始注册工作咯~\n", currentWorkerServer.getServerName());
        registCurrentWorkerServerNodeUnderServicesNode();
        //监听config节点数据变化
        zkClient.subscribeDataChanges(configNodePath, configNodeDataListener);
    }

    /**
     * @Description: 停止节点
     * @Author: whq
     * @Date: 2021/9/6 21:30
     */
    public void stop() {
        System.out.printf("%s 取消了对config节点的订阅\n", currentWorkerServer.getServerName());
        zkClient.unsubscribeDataChanges(configNodePath, configNodeDataListener);
    }

    /**
     * @Description: 将当前server节点注册到servers节点下
     * @Author: whq
     * @Date: 2021/9/6 21:19
     */
    private void registCurrentWorkerServerNodeUnderServicesNode() {
        final String NODE_SPLITTER = "/";
        try {
            zkClient.createEphemeral(serversNodePath + NODE_SPLITTER + currentWorkerServer.getServerName(),
                    JSON.toJSONString(currentWorkerServer).getBytes());
        } catch (ZkNoNodeException e) {
            //如果创建临时节点的时候发现父节点不存在，则先创建父节点
            zkClient.createPersistent(serversNodePath, true);
            registCurrentWorkerServerNodeUnderServicesNode();
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("registCurrentWorkerServerNodeUnderServicesNode发生异常了！" + e.getMessage());
        }
    }

    /**
     * @Description: 更新节点配置文件信息
     * @Author: whq
     * @Date: 2021/9/6 21:15
     */
    private void updateConfigData(ConfigPOJO configPOJO) {
        this.configPOJOData = configPOJO;
    }
}
