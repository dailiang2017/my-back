package com.dail.user.service;

import com.dail.user.dto.RoleODTO;
import com.dail.user.dto.RoleQueryDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {

    PageInfo<List<RoleODTO>> queryPage(RoleQueryDTO dto);
}
