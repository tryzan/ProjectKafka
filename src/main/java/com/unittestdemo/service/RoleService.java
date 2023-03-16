package com.unittestdemo.service;

import com.unittestdemo.dto.RegisterRoleDTO;
import com.unittestdemo.dto.ResponseMsgDTO;
import com.unittestdemo.entity.Role;

import java.util.List;

public interface RoleService {
    ResponseMsgDTO save(RegisterRoleDTO registerRole);
    List<Role> findAllRole();

    Role findRoleByName(String name);
}
