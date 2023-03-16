package com.unittestdemo.restcontroller;

import com.unittestdemo.dto.RegisterAccDTO;
import com.unittestdemo.dto.ResponseMsgDTO;
import com.unittestdemo.entity.Account;
import com.unittestdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody RegisterAccDTO registerAccDTO){
        ResponseMsgDTO response = accountService.saveAccount(registerAccDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> detailAccount(@PathVariable(required = true)String username){
        accountService.findbyId(username);
        return ResponseEntity.status(HttpStatus.OK).body("h");
    }

}
