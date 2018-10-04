package com.acme.acmetrade.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.acme.acmetrade.domain.Sector;
import com.acme.acmetrade.repository.MarketSectorRepository;

@Service
public class SectorService {
	
	Logger log = LoggerFactory.getLogger(SectorService.class);

    @Autowired
    private MarketSectorRepository marketSectorRepository;

    public int addMarketSector(Sector sector){
    	return marketSectorRepository.addMarketSector(sector);
    }
    
    public int updateMarketSector(Sector sector) {
    	return marketSectorRepository.updateMarketSector(sector);
    }
    
    public Sector getMarketSectorByName(String name) {
    	return marketSectorRepository.getMarketSectorByName(name);
    }
    
    public Sector getMarketSectorById(int id) {
    	try {
    		return marketSectorRepository.getMarketSectorById(id);
    	} catch (DataAccessException e) {
    		log.error("Unable to get market sector by id:\t{}", id, e);
    	}
    	return new Sector();    	
    }
    
    public List<Sector> getAllMarketSectors() {
    	return marketSectorRepository.getAllMarketSectors();
    }  
    
    public int deleteMarketSector(Sector sector) {
    	return marketSectorRepository.deleteMarketSector(sector);
    } 
    
    
}