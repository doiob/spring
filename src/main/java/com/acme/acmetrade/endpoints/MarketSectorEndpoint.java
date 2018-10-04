package com.acme.acmetrade.endpoints;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.acmetrade.domain.ResponseStatus;
import com.acme.acmetrade.domain.Sector;
import com.acme.acmetrade.services.SectorService;

@RestController
public class MarketSectorEndpoint {
	
	Logger log = LoggerFactory.getLogger(MarketSectorEndpoint.class);

	@Autowired
	SectorService service;

	@RequestMapping(value = "/sectors", method = RequestMethod.GET)
	public List<Sector> getSectors() {
		return service.getAllMarketSectors();
	}

	@RequestMapping(path = "/sectors", method = RequestMethod.POST)
	public ResponseStatus addSector(@RequestBody Sector sector) {
		int numRows = service.addMarketSector(sector);

		if (numRows != 1) {
			return new ResponseStatus(0, "Successfully added new sector");
		} else {
			return new ResponseStatus(1111, "Unable to add new sector");
		}
	}

	@RequestMapping(path = "/sectors/{id}", method = RequestMethod.GET)
	public Sector listSector(@PathVariable("id") int id) {
		return service.getMarketSectorById(id);
	}

	@RequestMapping(path = "/sectors/{id}", method = RequestMethod.DELETE)
	public ResponseStatus deleteSector(@PathVariable("id") int id) {
		int numRows = service.deleteMarketSector(new Sector(id, StringUtils.EMPTY, StringUtils.EMPTY));

		if (numRows != 1) {
			return new ResponseStatus(0, "Successfully deleted sector");
		} else {
			return new ResponseStatus(1111, "Unable to delete sector");
		}
	}

	public ResponseStatus updateMarketSector(Sector sector) {
		int numRows = service.updateMarketSector(sector);

		if (numRows != 1) {
			return new ResponseStatus(0, "Successfully updated sector");
		} else {
			return new ResponseStatus(1111, "Unable to updated sector");
		}
	}

	public Sector getMarketSectorByName(String name) {
		return service.getMarketSectorByName(name);
	}

}
