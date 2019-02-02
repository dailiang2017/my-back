package com.dail.user.service;

import com.dail.enums.IsDeletedEnum;
import com.dail.user.dto.RoleIDTO;
import com.dail.user.dto.RoleODTO;
import com.dail.user.dto.RoleQueryDTO;
import com.dail.user.mapper.RoleDAO;
import com.dail.user.mapper.UserDAO;
import com.dail.user.model.Role;
import com.dail.user.model.RoleExample;
import com.dail.utils.BeanUtil;
import com.dail.utils.ExceptionUtil;
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
        return PageHelper.startPage(dto.getPageNo(), dto.getPageSize()).doSelectPageInfo(() -> {
            BeanUtil.copyPropertiesForList(roleDAO.selectByExample(example), RoleODTO.class);
        });
    }

    @Override
    public Integer update(RoleIDTO dto) {
        checkParam(dto, 2);
        Role role = BeanUtil.copyProperties(dto, Role.class);
        role.preUpdate(dto.getUsername());
        return roleDAO.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer insert(RoleIDTO dto) {
        checkParam(dto, 1);
        Role role = BeanUtil.copyProperties(dto, Role.class);
        role.preInsert(dto.getUsername());
        return roleDAO.insertSelective(role);
    }

    /**
     * 校验参数
     * @param dto
     * @param type 1-新增 2-更新
     */
    private void checkParam(RoleIDTO dto, int type) {
        if (type == 2) {
            ExceptionUtil.isTrue(dto.getId() == null, "id不能为空");
        }
        ExceptionUtil.isTrue(StringUtil.isBlankOrEmpty(dto.getRole()), "角色信息必填");
        ExceptionUtil.isTrue(StringUtil.isBlankOrEmpty(dto.getDescription()), "角色描述必填");
    }
}
