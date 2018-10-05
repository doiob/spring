package com.acme.acmetrade.services;

import java.util.Collections;
import java.util.List;

import com.acme.acmetrade.exception.SecurityNotFoundException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.acme.acmetrade.domain.Sector;
import com.acme.acmetrade.domain.Security;
import com.acme.acmetrade.repository.MarketSectorRepository;
import com.acme.acmetrade.repository.SecurityRepository;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository ;

    @Autowired
    private MarketSectorRepository marketSectorRepository;

    public int addSecurity(Security security){
       try {
		return securityRepository.saveSecurity(security);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       return 0;
    }

    public int saveSecurity(Security security){
        try {
			return securityRepository.saveSecurity(security);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 0;
    }
    public int updateSecurity(Security security){
        try {
            int count = securityRepository.updateSecurity(security);
            if (count == 0){
                throw new SecurityNotFoundException("Security -"+security.getSymbol()+" Not Found");
            }
		}
        catch (SecurityNotFoundException e){
            throw e;
        }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 0;
    }
    public int deleteSecurityBySymbol(String symbol){
        try {
			int count = securityRepository.deleteSecurityBySymbol(symbol);
            if (count == 0){
                throw new SecurityNotFoundException("Security -"+symbol+" Not Found");
            }
            return count;
		}
        catch (SecurityNotFoundException e){
            throw e;
        }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 0;
    }

    public int deleteSecurityBySectorId(int sectorId){
        try {
            return securityRepository.deleteSecurityBySectorId(sectorId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
    public List<Security> getAllSecurities() 
    {
    	try {
			return securityRepository.retrieveAllSecurities();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Collections.emptyList();
    }
    public Security getSecurityBySymbol(String symbol) {
        Security sec = null;
    	try {
            sec = securityRepository.retrieveSecurityBySymbol(symbol);
		}
		catch (EmptyResultDataAccessException emptyEx){
    	    throw new SecurityNotFoundException("Security -"+symbol+" Not Found");
        }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sec;
    }
    public List<Security> getSecuritiesBySectorId(int sectorId) {
    	try {
			return securityRepository.retrieveSecuritiesBySectorId(sectorId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Collections.emptyList();

    }
}
