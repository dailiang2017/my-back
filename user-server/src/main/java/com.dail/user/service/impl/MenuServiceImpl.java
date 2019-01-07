package com.dail.user.service.impl;

import com.dail.user.dto.MenuDTO;
import com.dail.user.mapper.PermissionMapper;
import com.dail.user.model.Permission;
import com.dail.user.service.MenuService;
import com.dail.utils.BeanUtil;
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
        List<Permission> list = permissionMapper.queryUserMenu(userId);
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
        return null;
    }

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
