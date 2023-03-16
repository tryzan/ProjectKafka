package com.unittestdemo.restcontroller;

import com.unittestdemo.dto.RegisterRoleDTO;
import com.unittestdemo.dto.ResponseMsgDTO;
import com.unittestdemo.entity.Role;
import com.unittestdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerRole(@RequestBody RegisterRoleDTO registerRoleDTO){
        ResponseMsgDTO response = roleService.save(registerRoleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
