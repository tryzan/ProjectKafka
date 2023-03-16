package com.unittestdemo.service;

import com.unittestdemo.dao.AccountRepository;
import com.unittestdemo.dto.RegisterAccDTO;
import com.unittestdemo.dto.ResponseMsgDTO;
import com.unittestdemo.entity.Role;
import com.unittestdemo.entity.Account;
import com.unittestdemo.exceptionhandler.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private RoleService roleService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RoleService roleService){
        this.accountRepository = accountRepository;
        this.roleService = roleService;
    }

    @Override
    public ResponseMsgDTO saveAccount(RegisterAccDTO registerAcc) {
        List<Role> listRole = roleService.findAllRole();
        Set<Role> accountRole = new HashSet<>();
        if(!listRole.isEmpty()) {
                Account newAccount = accountRepository.findById(registerAcc.getUsername()).orElse(new Account());
                newAccount.setUsername(registerAcc.getUsername());
                newAccount.setPassword(registerAcc.getPassword());
                for (Role role : registerAcc.getRole()) {
                    accountRole.add(roleService.findRoleByName(role.getName()));
                }
                newAccount.setRoles(accountRole);
                newAccount.setFirstName(registerAcc.getFirstName());
                newAccount.setLastName(registerAcc.getLastName());
                newAccount.setAddress(registerAcc.getAddress());
                newAccount.setPhoneNo(registerAcc.getPhoneNo());
                accountRepository.save(newAccount);
                log.info("Succesfully save account : " + newAccount);
                return new ResponseMsgDTO(true,"Succesfuly Save Account with Username : "+registerAcc.getUsername());
        }else{
            throw new CustomException("List of Role is empty. Contact the Administrator to create a Role first");
        }
    }

    @Override
    public Account findbyId(String username) {
        Optional<Account> nullableEntity = accountRepository.findById(username);
        return nullableEntity.orElseThrow(()->{
            throw new CustomException("Account Not Found");
        });
    }
}
