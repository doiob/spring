package com.acme.acmetrade.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.acmetrade.domain.Sector;
import com.acme.acmetrade.domain.Security;
import com.acme.acmetrade.services.SecurityService;

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
	
//	@Autowired
//	private SecurityService securityService;
//
//	@RequestMapping(path = "/securities" , method = RequestMethod.GET)
//	public List<Security> listSecurities() {
//		return new ArrayList<Security>();
//	}
//
//	@RequestMapping(path = "/securities/{symbol}" , method = RequestMethod.GET)
//	public Security listSecurity(@PathParam("symbol") String symbol) {
//		return new Security();
//	}
//
//	@RequestMapping(path = "/securities" , method = RequestMethod.POST)
//	public Security addSecurity(@RequestBody Security security) {
//		return security;
//	}
//
//	@RequestMapping(path = "/securities/{symbol}" , method = RequestMethod.DELETE)
//	public void deleteSecurity(@PathParam("symbol") String symbol) {
//
//	}
}
