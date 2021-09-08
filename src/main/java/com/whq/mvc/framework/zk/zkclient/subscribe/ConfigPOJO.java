package com.whq.mvc.framework.zk.zkclient.subscribe;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: 配置文件信息
 * @Author: whq
 * @Date: 2021/9/6 20:47
 */
@Data
@ToString
public class ConfigPOJO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nameConfig;
    private int ageConfig;
    private String genderConfig;
    private String mottoConfig;
}
