package com.dail.user.service;

import com.dail.user.dto.MenuDTO;
import com.dail.user.dto.MenuIDTO;

import java.util.List;

public interface MenuService {

    public List<MenuDTO> queryUserMenu(Long userId);

    public List<MenuDTO> queryMenuTree();

    public Integer deleteMenu(Long id);

    public Integer addMenu(MenuIDTO dto);
}
