package org.utility.modules.mnt.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 部署历史管理
 *
 * @author Li Yanfeng
 * @since 2021-07-01
 */
@TableName(value = "mnt_deploy_history")
public class DeployHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "history_id", type = IdType.ASSIGN_ID)
    private Long historyId;

    @ApiModelProperty(value = "应用名称")
    @NotBlank
    private String appName;

    @ApiModelProperty(value = "部署日期")
    @NotNull
    private Date deployDate;

    @ApiModelProperty(value = "部署用户")
    @NotBlank
    private String deployUser;

    @ApiModelProperty(value = "服务器IP")
    @NotBlank
    private String ip;

    @ApiModelProperty(value = "部署编号")
    private Long deployId;


    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public String getDeployUser() {
        return deployUser;
    }

    public void setDeployUser(String deployUser) {
        this.deployUser = deployUser;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getDeployId() {
        return deployId;
    }

    public void setDeployId(Long deployId) {
        this.deployId = deployId;
    }
}
