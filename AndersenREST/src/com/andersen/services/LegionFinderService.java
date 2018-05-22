package com.andersen.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.andersen.JDBC.QueryExecutor;

/*
 *  loads Legion name (via XML) from Data Base by id
 */

@Path("/findLegion")
public class LegionFinderService {

	@Path("{legionId}")
	@GET
	@Produces("application/xml")
	public String executeLegionInfoByName(@PathParam("legionId") int legionId) {

		return "<LegionName>" + QueryExecutor.findLegionById(legionId) + "</LegionName>";
	}
}
