package com.acme.acmetrade.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.acme.acmetrade.TradeApplication;
import com.acme.acmetrade.domain.Sector;

@Sql(scripts= {"classpath:/testableSector.sql"})
@RunWith(SpringRunner.class) 
@SpringBootTest(classes = {TradeApplication.class})

public class MarketSectorTest {
	
	@Autowired
	MarketSectorRepository marketSectorRepository;
	
	@Test
	@Transactional
	public void getAllSectors() {
		List<Sector> sectors = marketSectorRepository.getAllMarketSectors();
		assertThat(sectors.size(), greaterThan(0));
	}
	
	@Test
	@Transactional
	public void getSectorId() {
		int sectorIdNum = marketSectorRepository.getSectorId("Health");
		assertThat(sectorIdNum, not(equalTo(null)));
	}
	
	@Test
	@Transactional
	public void addSector() {
		Sector sector = new Sector("Techno", "Tech Companies");
		int count = marketSectorRepository.addMarketSector(sector);
		assertThat(count, equalTo(1));
	}
	
	@Test
	@Transactional
	public void updateSector() {
		Sector sector = marketSectorRepository.getMarketSectorByName("Health");
		sector.setSectorName("NewSectorName");
		sector.setSectorDesc("This is a new description");
		marketSectorRepository.updateMarketSector(sector);
		Sector updatedSector = marketSectorRepository.getMarketSectorByName("NewSectorName");
		assertThat(updatedSector.getSectorName(), equalTo("NewSectorName"));
	}
	
	@Test
	@Transactional
	public void getSectorByName() {
		Sector sector = marketSectorRepository.getMarketSectorByName("Health");
		assertThat(sector, not(equalTo(null)));
	}
	
	@Test
	@Transactional
	public void deleteSector() {
		Sector sector = marketSectorRepository.getMarketSectorByName("Health");
		int count = marketSectorRepository.deleteMarketSector(sector);
		assertThat(count, equalTo(1));
	}
	
	
}
