package com.dail.user.dto;

import com.dail.user.model.User;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: dailiang
 * @Date: 2018/12/29 17:33
 * @Description:
 */
public class UserDTO extends User implements Serializable {

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
}
