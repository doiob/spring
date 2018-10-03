package com.acme.acmetrade.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.acmetrade.domain.Sectors;

@RestController
public class SectorsEndpoint {	
		
	@RequestMapping(value="/sectors", method = RequestMethod.GET)	
	public List<Sectors> getSectors(){
		return new ArrayList<Sectors>();
	}

	@RequestMapping(path = "/sectors" , method = RequestMethod.POST)
	public Sectors addSector(@RequestBody Sectors sector) {		
		return new Sectors(0, "test", "test");
	}
}
