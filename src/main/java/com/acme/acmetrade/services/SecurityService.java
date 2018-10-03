package com.acme.acmetrade.services;

import com.acme.acmetrade.domain.Security;
import com.acme.acmetrade.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;

    public void addSecurity(Security security){
        securityRepository.saveSecurity(security);
    }

}
