package com.dail.user.service;

import com.dail.user.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    public List<MenuDTO> queryUserMenu(Long userId);
}