package org.utility.modules.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 角色部门关联
 *
 * @author Li Yanfeng
 * @since 2021-06-27
 */
@TableName(value = "sys_role_dept")
public class RoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private Long roleId;

    @ApiModelProperty(value = "部门ID")
    @TableField(value = "dept_id")
    private Long deptId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
