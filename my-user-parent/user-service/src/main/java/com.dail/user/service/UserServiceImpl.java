package com.dail.user.service;

import com.dail.enums.IsDeletedEnum;
import com.dail.enums.UserStatusEnum;
import com.dail.user.dto.UserDTO;
import com.dail.user.dto.UserQueryDTO;
import com.dail.user.mapper.UserMapper;
import com.dail.user.model.User;
import com.dail.user.model.UserExample;
import com.dail.utils.BeanUtil;
import com.dail.utils.ExceptionUtil;
import com.dail.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: dailiang
 * @Date: 2018/12/18 11:03
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findByUserId(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return BeanUtil.copyProperties(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> list = userMapper.selectAll();
        return BeanUtil.copyPropertiesForList(list, UserDTO.class);
    }

    @Override
    public UserDTO findByName(String username) {
        User user = userMapper.findByName(username);
        return BeanUtil.copyProperties(user, UserDTO.class);
    }

    @Override
    public PageInfo<List<UserDTO>> queryUserPage(UserQueryDTO queryDTO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (StringUtil.isNotEmpty(queryDTO.getUsername())) {
            criteria.andUsernameLike(StringUtil.setLikeSQL(queryDTO.getUsername()));
        }
        criteria.andIsDeletedEqualTo(IsDeletedEnum.N.getCode());
        return PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize()).doSelectPageInfo(() -> {
            userMapper.selectByExample(userExample);
        });
    }

    @Override
    public Integer update(UserDTO userDTO) {
        ExceptionUtil.isTrue(userDTO == null, "参数不能为空");
        ExceptionUtil.isTrue(userDTO.getId() == null, "用户id不能为空");
        return userMapper.updateByPrimaryKeySelective(BeanUtil.copyProperties(userDTO, User.class));
    }

    @Override
    public Integer insert(UserDTO userDTO) {
        ExceptionUtil.isTrue(userDTO == null, "参数不能为空");
        ExceptionUtil.isTrue(StringUtil.isBlankOrEmpty(userDTO.getUsername()), "用户名不能为空");
        ExceptionUtil.isTrue(StringUtil.isBlankOrEmpty(userDTO.getRealname()), "姓名不能为空");
        ExceptionUtil.isTrue(StringUtil.isBlankOrEmpty(userDTO.getMobile()), "手机不能为空");
        userDTO.setStatus(UserStatusEnum.NORMAL.getCode());
        // 暂时默认
        userDTO.setPassword("123456");
        userDTO.setSalt("salt");
        return userMapper.insertSelective(BeanUtil.copyProperties(userDTO, User.class));
    }
}
