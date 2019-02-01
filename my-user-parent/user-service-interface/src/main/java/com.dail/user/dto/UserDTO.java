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

    public void preInsert(String username) {
        Date now = new Date();
        this.setCreator(username);
        this.setModifier(username);
        this.setCreateTime(now);
        this.setModifyTime(now);
    }

    public void preUpdate(String username) {
        Date now = new Date();
        this.setModifier(username);
        this.setModifyTime(now);
    }

    public void preDelete(String username, Long id) {
        Date now = new Date();
        this.setId(id);
        this.setModifier(username);
        this.setModifyTime(now);
        this.setIsDeleted(IsDeletedEnum.Y.getCode());
    }
}
