package com.dail.user.service;

import com.dail.enums.IsDeletedEnum;
import com.dail.user.dto.MenuDTO;
import com.dail.user.mapper.PermissionMapper;
import com.dail.user.model.Permission;
import com.dail.user.model.PermissionExample;
import com.dail.utils.BeanUtil;
import com.dail.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<MenuDTO> queryUserMenu(Long userId) {
        return getMenuTree(permissionMapper.queryUserMenu(userId));
    }

    @Override
    public List<MenuDTO> queryMenuTree() {
        // 获得所有的菜单
        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(IsDeletedEnum.N.getCode());
        return getMenuTree(permissionMapper.selectByExample(example));
    }

    @Override
    public Integer deleteMenu(Long id) {
        ExceptionUtil.isTrue(id == null, "id不能为空");
        return permissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * list 转化tree
     * @param list
     * @return
     */
    private List<MenuDTO> getMenuTree(List<Permission> list) {
        List<MenuDTO> oneList = new ArrayList<>();
        List<MenuDTO> treeList = new ArrayList<>();
        for (Permission dto : list) {
            MenuDTO menuDTO = BeanUtil.copyProperties(dto, MenuDTO.class);
            // 找出根级菜单，约定所有根菜单的ParentId都是0
            if (dto.getParentId() == null || dto.getParentId().equals(0L)) {
                oneList.add(menuDTO);
            }
            treeList.add(menuDTO);
        }
        for (MenuDTO dto : oneList) {
            dto.setChildren(getChildNodes(treeList, dto.getId()));
        }
        return oneList;
    }

    /**
     * 递归查询子节点
     * @param treeList
     * @param id
     * @return
     */
    private List<MenuDTO> getChildNodes(List<MenuDTO> treeList, Long id) {
        List<MenuDTO> childList = new ArrayList<>();
        for (MenuDTO dto : treeList) {
            if (id.equals(dto.getParentId())) {
                childList.add(dto);
            }
        }
        if (childList.size() == 0) {
            return null;
        }
        for (MenuDTO dto : childList) {
            dto.setChildren(getChildNodes(treeList, dto.getId()));
        }
        return childList;
    }
}
