package com.dail.user.controller;

import com.dail.dto.BaseResult;
import com.dail.dto.TokenInfo;
import com.dail.user.service.MenuService;
import com.dail.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/queryUserMenu")
    public BaseResult queryUserMenu() {
        TokenInfo userDTO = UserUtil.getUserInfo();
        return BaseResult.success(menuService.queryUserMenu(userDTO.getId()));
    }
}
