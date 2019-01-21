package com.dail.user.dto;

import com.dail.dto.BaseModel;
import com.dail.enums.IsDeletedEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: dailiang
 * @Date: 2018/12/29 17:33
 * @Description:
 */
@Data
public class UserDTO extends BaseModel {

    private String username;

    private String realname;

    private String password;

    private String salt;

    private Integer status;

    private String mobile;

    private String email;

    private String adress;

    private Date lastLoginTime;

    private String remark;

    public void preInsert(Long userId) {
        Date now = new Date();
        this.setCreateId(userId);
        this.setUpdateId(userId);
        this.setCreateTime(now);
        this.setUpdateTime(now);
    }

    public void preUpdate(Long userId) {
        Date now = new Date();
        this.setUpdateId(userId);
        this.setUpdateTime(now);
    }

    public void preDelete(Long userId, Long id) {
        Date now = new Date();
        this.setId(id);
        this.setUpdateId(userId);
        this.setUpdateTime(now);
        this.setIsDeleted(IsDeletedEnum.Y.getCode());
    }
}
