package com.andersen.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import com.andersen.wrappers.LegionCamp;

/*
 *  sends JSON with  legion camp information to the Client
 */

@Path("/printLegionCamp")
public class CampFinderService {
	
	@GET
	@Produces("application/json")
	public LegionCamp printLegionCamp() {
		LegionCamp camp = new LegionCamp();
		camp.setCampName("Calabria");
		camp.setLegionersCount(10000);
		return  camp;
	}
}
