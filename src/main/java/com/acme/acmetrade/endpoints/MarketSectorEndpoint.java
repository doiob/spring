package com.acme.acmetrade.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.acmetrade.domain.Sector;

@RestController
public class MarketSectorEndpoint {	
		
	@RequestMapping(value="/sectors", method = RequestMethod.GET)	
	public List<Sector> getSectors(){
		return new ArrayList<Sector>();
	}

	@RequestMapping(path = "/sectors" , method = RequestMethod.POST)
	public Sector addSector(@RequestBody Sector sector) {		
		return new Sector(0, "test", "test");
	}
}
