package com.acme.acmetrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.acmetrade.domain.Sector;
import com.acme.acmetrade.repository.MarketSectorRepository;

@Service
public class SectorService {

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
    
    public List<Sector> getAllMarketSectors() {
    	return marketSectorRepository.getAllMarketSectors();
    }  
    
    public int deleteMarketSector(Sector sector) {
    	return marketSectorRepository.deleteMarketSector(sector);
    } 
    
    
}