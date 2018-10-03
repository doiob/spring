package com.acme.acmetrade.services;

import com.acme.acmetrade.domain.Security;
import com.acme.acmetrade.repository.MarketSectorRepository;
import com.acme.acmetrade.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository ;

    @Autowired
    private MarketSectorRepository marketSectorRepository;

    public void addSecurity(Security security){
       securityRepository.saveSecurity(security);
    }

    public Security getSecurityBySymbol(String symbol){
        return securityRepository.retrieveSecurityBySymbol(symbol);
    }
}
