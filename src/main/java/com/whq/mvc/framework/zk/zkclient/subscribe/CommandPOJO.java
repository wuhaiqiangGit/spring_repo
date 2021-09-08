package com.whq.mvc.framework.zk.zkclient.subscribe;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: command节点pojo
 * @Author: whq
 * @Date: 2021/9/6 20:51
 */
@Data
@ToString
public class CommandPOJO implements Serializable {
    private static final long serialVersionUID = 1L;

    private ManageServer.Command command;
    private ConfigPOJO configPOJO;

    public static void main(String[] args) {
        ConfigPOJO configPOJO = new ConfigPOJO();
        configPOJO.setNameConfig("wuhaiqiang");
        configPOJO.setAgeConfig(26);
        configPOJO.setGenderConfig("male");
        configPOJO.setMottoConfig("医者黑心");

        CommandPOJO commandPOJO = new CommandPOJO();
        commandPOJO.setCommand(ManageServer.Command.COMMAND_LIST);
        commandPOJO.setConfigPOJO(configPOJO);

        String json = JSON.toJSONString(commandPOJO);
        System.out.printf("json: %s\n",json);
    }

}
