package com.dail.user;

import com.dail.UserServiceApplication;
import com.dail.user.mapper.RoleDAO;
import com.dail.user.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: dailiang
 * @Date: 2019/1/30 11:40
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class TestSQL {

    @Autowired
    private RoleDAO roleDAO;

    private static final int total = 10000;

    @Test
    public void testInsert() {
        List<Role> list = new ArrayList<>();
        Date now = new Date();
        for (int i = 0; i < total; i++) {
            Role role = new Role();
            role.setRole("role" + i);
            role.setDescription("description");
            role.setCreator("0");
            role.setCreateTime(now);
            role.setModifier("0");
            role.setModifyTime(now);
            list.add(role);
        }
        long t0 = System.currentTimeMillis();
        roleDAO.insertList(list);
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
    }


    @Test
    public void testUpdate() {
        List<Role> list = new ArrayList<>();
        Date now = new Date();
        for (int i = 0; i < 2*total; i++) {
            Role role = new Role();
            role.setRole("role" + i);
            role.setDescription("description");
            role.setCreator("0");
            role.setCreateTime(now);
            role.setModifier("0");
            role.setModifyTime(now);
            list.add(role);
        }
        long t0 = System.currentTimeMillis();
        roleDAO.deleteAll();
        roleDAO.updateList(list);
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
    }

    @Test
    public void test() {
        List<Role> list = new ArrayList<>();
        Date now = new Date();
        for (int i = 0; i < total; i++) {
            Role role = new Role();
            role.setRole("role" + i);
            role.setDescription("description");
            role.setCreator("0");
            role.setCreateTime(now);
            role.setModifier("0");
            role.setModifyTime(now);
            list.add(role);
        }

        List<Role> list2 = new ArrayList<>();
        for (int i = total; i < 2*total; i++) {
            Role role = new Role();
            role.setRole("role" + i);
            role.setDescription("description");
            role.setCreator("0");
            role.setCreateTime(now);
            role.setModifier("0");
            role.setModifyTime(now);
            list2.add(role);
        }
        long t0 = System.currentTimeMillis();
        roleDAO.updateList(list);
        roleDAO.insertList(list2);
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
    }
}
