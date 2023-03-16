package com.unittestdemo.service;

import com.unittestdemo.dto.RegisterAccDTO;
import com.unittestdemo.dto.ResponseMsgDTO;
import com.unittestdemo.entity.Account;

public interface AccountService {
    ResponseMsgDTO saveAccount(RegisterAccDTO registerAcc);

    Account findbyId(String username);
}
