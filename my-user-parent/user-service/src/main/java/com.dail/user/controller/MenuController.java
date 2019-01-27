package com.dail.user.controller;

import com.dail.dto.TokenInfo;
import com.dail.user.dto.MenuDTO;
import com.dail.user.dto.MenuIDTO;
import com.dail.user.service.MenuService;
import com.dail.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/queryUserMenu")
    public List<MenuDTO> queryUserMenu() {
        TokenInfo userDTO = UserUtil.getUserInfo();
        return menuService.queryUserMenu(userDTO.getId());
    }

    @GetMapping("/queryMenuTree")
    public List<MenuDTO> queryMenuTree() {
        return menuService.queryMenuTree();
    }

    @GetMapping("/deleteMenu/{id}")
    public Integer deleteMenu(@PathVariable("id") Long id) {
        return menuService.deleteMenu(id);
    }

    @PostMapping("/addMenu")
    public Integer addMenu(@RequestBody MenuIDTO dto) {
        TokenInfo userDTO = UserUtil.getUserInfo();
        dto.setUserId(userDTO.getId());
        return menuService.addMenu(dto);
    }
}
