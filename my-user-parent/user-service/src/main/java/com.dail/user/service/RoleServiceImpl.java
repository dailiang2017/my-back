package com.dail.user.service;

import com.dail.enums.IsDeletedEnum;
import com.dail.user.dto.RoleODTO;
import com.dail.user.dto.RoleQueryDTO;
import com.dail.user.mapper.RoleDAO;
import com.dail.user.mapper.UserDAO;
import com.dail.user.model.RoleExample;
import com.dail.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public PageInfo<List<RoleODTO>> queryPage(RoleQueryDTO dto) {
        // 查询角色信息
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(dto.getRole())) {
            criteria.andRoleLike(StringUtil.setLikeSQL(dto.getRole()));
        }
        criteria.andIsDeletedEqualTo(IsDeletedEnum.N.getCode());
        List<RoleODTO> list = roleDAO.queryRolePage(dto);
        return PageHelper.startPage(dto.getPageNo(), dto.getPageSize()).doSelectPageInfo(() -> {
            roleDAO.selectByExample(example);
        });
    }
}
