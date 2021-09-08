package com.whq.mvc.framework.zk.zkclient.subscribe;

import lombok.Data;
import lombok.ToString;

/** 
 * @Description: server节点信息 
 * @Author: whq
 * @Date: 2021/9/6 20:53
 */
@Data
@ToString
public class WorkerServerParamModel {
    
    private int serverId;
    private String serverName;
}
