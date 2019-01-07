package com.dail;

import com.dail.user.dto.MenuDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: dailiang
 * @Date: 2019/1/7 14:32
 * @Description:
 */
public class TestTree {

    private static List<MenuDTO> treeList = new ArrayList<>();

    static {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(1L);
        menuDTO.setName("系统管理");
        menuDTO.setLevel(1);
        menuDTO.setParentId(0L);
        menuDTO.setSortNum(0);
        menuDTO.setUrl("");
        treeList.add(menuDTO);
        menuDTO = new MenuDTO();
        menuDTO.setId(2L);
        menuDTO.setName("用户管理");
        menuDTO.setLevel(2);
        menuDTO.setParentId(1L);
        menuDTO.setSortNum(1);
        menuDTO.setUrl("");
        treeList.add(menuDTO);
        menuDTO = new MenuDTO();
        menuDTO.setId(3L);
        menuDTO.setName("角色管理");
        menuDTO.setLevel(1);
        menuDTO.setParentId(1L);
        menuDTO.setSortNum(2);
        menuDTO.setUrl("");
        treeList.add(menuDTO);
    }

    public static void main(String[] args) {
        List<MenuDTO> oneList = new ArrayList<>();
        for (MenuDTO dto : treeList) {
            // 找出根级菜单，约定所有根菜单的ParentId都是0
            if (dto.getParentId() == null || dto.getParentId().equals(0L)) {
                oneList.add(dto);
            }
        }
        for (MenuDTO dto : oneList) {
            dto.setChildren(getChildNodes(treeList, dto.getId()));
        }
        System.out.println(oneList);
    }

    private static List<MenuDTO> getChildNodes(List<MenuDTO> treeList, Long id) {
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
