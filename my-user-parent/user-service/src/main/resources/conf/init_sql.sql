-- 用户初始化数据：系统管理员
INSERT INTO `my_mall`.`t_user` (`username`, `realname`, `password`, `salt`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES ('admin', '系统管理员', '123456', 'sss', '0', now(), '0', now());
-- 菜单初始化数据
INSERT INTO `my_mall`.`t_permission` (`parent_id`, `name`, `resource_type`,  `url`,`sort_num`, `level`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (0, '系统管理', 1, '', 0, 1, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_permission` (`parent_id`, `name`, `resource_type`,  `url`,`sort_num`, `level`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, '用户管理', 1, '/sys/user', 1, 2, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_permission` (`parent_id`, `name`, `resource_type`,  `url`,`sort_num`, `level`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, '菜单管理', 1, '/sys/menu', 2, 2, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_permission` (`parent_id`, `name`, `resource_type`,  `url`,`sort_num`, `level`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, '角色管理', 1, '/sys/role', 3, 2, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_permission` (`parent_id`, `name`, `resource_type`,  `url`,`sort_num`, `level`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, '角色菜单配置', 1, '/sys/roleMenu', 4, 2, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_permission` (`parent_id`, `name`, `resource_type`,  `url`,`sort_num`, `level`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, '用户角色配置', 1, '/sys/userRole', 5, 2, '0', now(), '0', now());
-- 角色初始化数据
INSERT INTO `my_mall`.`t_role` (`role`, `description`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES ('admin', '超级管理员', '0', now(), '0', now());
-- 用户角色初始化数据
INSERT INTO `my_mall`.`t_user_role` (`user_id`, `role_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 1, '0', now(), '0', now());
-- 角色菜单初始化数据
INSERT INTO `my_mall`.`t_role_permission` (`role_id`, `permission_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 1, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_role_permission` (`role_id`, `permission_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 2, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_role_permission` (`role_id`, `permission_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 3, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_role_permission` (`role_id`, `permission_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 4, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_role_permission` (`role_id`, `permission_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 5, '0', now(), '0', now());
INSERT INTO `my_mall`.`t_role_permission` (`role_id`, `permission_id`, `creator`, `create_time`, `modifier`, `modify_time`) VALUES (1, 6, '0', now(), '0', now());