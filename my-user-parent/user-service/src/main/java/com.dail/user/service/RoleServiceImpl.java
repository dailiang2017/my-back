package com.dail.user.service;

import com.dail.enums.IsDeletedEnum;
import com.dail.user.dto.RoleODTO;
import com.dail.user.dto.RoleQueryDTO;
import com.dail.user.mapper.RoleMapper;
import com.dail.user.mapper.UserMapper;
import com.dail.user.model.RoleExample;
import com.dail.user.model.UserExample;
import com.dail.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<List<RoleODTO>> queryPage(RoleQueryDTO dto) {
        // 查询角色信息
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(dto.getRole())) {
            criteria.andRoleLike(StringUtil.setLikeSQL(dto.getRole()));
        }
        criteria.andIsDeletedEqualTo(IsDeletedEnum.N.getCode());
        List<RoleODTO> list = roleMapper.queryRolePage(dto);
        return PageHelper.startPage(dto.getPageNo(), dto.getPageSize()).doSelectPageInfo(() -> {
            roleMapper.selectByExample(example);
        });
    }
}
