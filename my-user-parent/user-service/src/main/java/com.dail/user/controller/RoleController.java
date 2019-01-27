package com.dail.user.controller;

import com.dail.user.dto.RoleODTO;
import com.dail.user.dto.RoleQueryDTO;
import com.dail.user.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/queryPage")
    PageInfo<List<RoleODTO>> queryPage(@RequestBody RoleQueryDTO dto) {
        return roleService.queryPage(dto);
    }
}
