package com.whq.mvc.framework.zk.zkclient.subscribe;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.List;

/**
 * @Description:  集群配置中心数据管理
 * @Author: whq
 * @Date: 2021/9/6 22:16
 */
public class ManageServer {

    private final String NODE_SPLITTER = "/";

    private ZkClient zkClient;

    //servers node路径
    private String serversNodePath;
    //command node路径
    private String commandNodePath;
    //config node节点路径
    private String configNodePath;

    //command节点数据
    private CommandPOJO commandNodeData;

    //监听command节点数据变化的监听器
    private IZkDataListener commandNodeDataListener;
    //监听servers节点 子节点变化的监听器
    private IZkChildListener serversNodeChildListener;
    //servers节点下的所有子节点
    private List<String> workerServerList;

    public ManageServer(ZkClient zkClient, String serversNodePath, String commandNodePath, String configNodePath) {
        this.zkClient = zkClient;
        this.serversNodePath = serversNodePath;
        this.commandNodePath = commandNodePath;
        this.configNodePath = configNodePath;
        this.commandNodeDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                String commandNodeDataJsonString = new String((byte[]) data);
                commandNodeData = JSON.parseObject(commandNodeDataJsonString, CommandPOJO.class);
                exeCmd();
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }
        };
        this.serversNodeChildListener = new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                workerServerList = currentChilds;
                System.out.printf("servers节点的子节点列表发生了变化！");
                execList();
            }
        };
    }

    public void start() {
        createCommandNode();
        //添加对command节点的数据变化监听
        zkClient.subscribeDataChanges(commandNodePath,commandNodeDataListener);
        //添加对servers节点数据变化的监听
        zkClient.subscribeChildChanges(serversNodePath,serversNodeChildListener);
    }

    public void stop() {
        //取消监听command节点的数据变化
        zkClient.unsubscribeDataChanges(commandNodePath, commandNodeDataListener);
        //取消监听servers节点的子节点数据变化
        zkClient.unsubscribeChildChanges(serversNodePath, serversNodeChildListener);
    }

    //创建command节点
    private void createCommandNode() {
        if (!zkClient.exists(commandNodePath)) {
            try {
                zkClient.createPersistent(commandNodePath);
            } catch (ZkNodeExistsException e) {
                //有其他线程创建了command节点，直接return就行
                return;
            } catch (ZkNoNodeException e) {
                String parentNodePath = commandNodePath.substring(0, commandNodePath.lastIndexOf("/"));
                zkClient.createPersistent(parentNodePath, true);
                createCommandNode();
            } catch (Exception e) {
                System.err.println("发生其他异常了！" + e.getMessage());
            }
        }
    }

    /**
     * @Description: 查看servers节点下数据
     * @Author: whq
     * @Date: 2021/9/6 21:48
     */
    private void execList() {
        System.out.printf("此时servers节点下的所有子节点有：%s\n", workerServerList);
    }

    /**
     * @Description: 处理config节点创建指令
     * @Author: whq
     * @Date: 2021/9/6 21:55
     */
    private void execCreate() {
        if (!zkClient.exists(configNodePath)) {
            try {
                zkClient.createPersistent(configNodePath, JSON.toJSONString(commandNodeData.getConfigPOJO()).getBytes());
            } catch (ZkNodeExistsException e) {
                //多线程竞争刚刚创建了config节点，则修改config节点数据
                zkClient.writeData(configNodePath, JSON.toJSONString(commandNodeData.getConfigPOJO()).getBytes());
                e.printStackTrace();
            } catch (ZkNoNodeException e) {
                //创建config节点，父节点不存在的情况，先创建父节点
                String parentNodePath = configNodePath.substring(0, configNodePath.lastIndexOf(NODE_SPLITTER));
                zkClient.createPersistent(parentNodePath, true);
                execCreate();
            } catch (Exception e) {
                System.err.println("发生其他异常了！" + e.getMessage());
            }
        }
    }

    /**
     * @Description: 处理config节点信息的修改
     * @Author: whq
     * @Date: 2021/9/6 22:07
     */
    private void execModify() {
        if (zkClient.exists(configNodePath)) {
            try {
                zkClient.writeData(configNodePath, JSON.toJSONString(commandNodeData.getConfigPOJO()).getBytes());
            } catch (ZkNoNodeException e) {
                execCreate();
                e.printStackTrace();
            }
        } else {
            execCreate();
        }
    }

    /**
     * @Description: command节点操作相关
     * @Author: whq
     * @Date: 2021/9/6 21:50
     */
    private void exeCmd() {
        Command command = commandNodeData.getCommand();
        switch (command) {
            case COMMAND_LIST:
                System.out.printf("检测到command中数据发生变化，处理相应的list指令");
                execList();
                break;
            case COMMAND_CREATE:
                System.out.printf("检测到command中数据发生变化，处理相应的create指令");
                execCreate();
                break;
            case COMMAND_MODIFY:
                System.out.printf("检测到command中数据发生变化，处理相应的modify指令");
                execModify();
                break;
            default:
                break;
        }


    }

    static enum Command {
        COMMAND_LIST, COMMAND_CREATE, COMMAND_MODIFY
    }
}
