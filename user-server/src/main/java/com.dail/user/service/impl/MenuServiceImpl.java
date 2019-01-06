package com.dail.user.service.impl;

import com.dail.user.dto.MenuDTO;
import com.dail.user.mapper.PermissionMapper;
import com.dail.user.model.Permission;
import com.dail.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<MenuDTO> queryUserMenu(String userId) {
        List<Permission> list = permissionMapper.queryUserMenu(userId);
        List<MenuDTO> treeList = new ArrayList<>();
        for (Permission permission : list) {
        }
        return null;
    }
}
