package com.andersen.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.andersen.model.Legion;

/*
 * Implementation of LegionService, CRUD operations on Legion instance
 */

public class LegionServiceImpl implements LegionService {

	private static Set<Legion> legionSet = new HashSet<Legion>();

	@Override
	public boolean addLegion(Legion legion) {
		return legionSet.add(legion);
	}

	@Override
	public boolean deleteLegion(String legionName) {
		for (Iterator<Legion> iterator = legionSet.iterator(); iterator.hasNext();) {
			Legion legion = iterator.next();
			if (legion.getLegionName().equals(legionName)) {
				return legionSet.remove(legion);
			}
		}
		return false;
	}

	@Override
	public Legion getLegion(String legionName) {
		for (Iterator<Legion> iterator = legionSet.iterator(); iterator.hasNext();) {
			Legion legion = iterator.next();
			if (legion.getLegionName().equals(legionName)) {
				return legion;
			}
		}
		return null;
	}

	@Override
	public Legion[] getAllLegions() {
		Legion[] legionsArray = legionSet.toArray(new Legion[legionSet.size()]);
		return legionsArray;
	}
}
