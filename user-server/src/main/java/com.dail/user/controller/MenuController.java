package com.dail.user.controller;

import com.dail.dto.BaseResult;
import com.dail.dto.UserDTO;
import com.dail.user.dto.MenuDTO;
import com.dail.user.service.MenuService;
import com.dail.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/queryUserMenu")
    public BaseResult queryUserMenu() {
        UserDTO userDTO = ThreadLocalUtil.getTokenInfo();
        return BaseResult.success(menuService.queryUserMenu(userDTO.getId()));
    }
}
