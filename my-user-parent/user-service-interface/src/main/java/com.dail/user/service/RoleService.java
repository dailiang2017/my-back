package com.dail.user.service;

import com.dail.user.dto.RoleIDTO;
import com.dail.user.dto.RoleODTO;
import com.dail.user.dto.RoleQueryDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {

    PageInfo<List<RoleODTO>> queryPage(RoleQueryDTO dto);

    Integer update(RoleIDTO dto);

    Integer insert(RoleIDTO dto);
}
