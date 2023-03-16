package com.unittestdemo.service;

import com.unittestdemo.dao.RoleRepository;
import com.unittestdemo.dto.RegisterRoleDTO;
import com.unittestdemo.dto.ResponseMsgDTO;
import com.unittestdemo.entity.Role;
import com.unittestdemo.exceptionhandler.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseMsgDTO save(RegisterRoleDTO registerRole) {
        Role newRole = new Role();
        newRole.setName(registerRole.getName());
        roleRepository.save(newRole);
        log.info("Succesfully saved a new role : " + registerRole.getName());
        return new ResponseMsgDTO(true,"Succesfully saved a new role : "+ registerRole.getName()) ;
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(String name) {
        Role role = roleRepository.findRoleByName(name);
        if(role == null){
            throw new CustomException("Role is not Found");
        }
        return role;
    }
}
