package com.people10.assignment.AssignmentPeople10.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RepoService {

	public HashMap<String, Integer> getUnsortedMap() {

		HashMap<String, Integer> hp = new HashMap<String, Integer>();

		hp.put("Texas", 200);
		hp.put("california", 300);
		hp.put("maldives", 400);
		hp.put("sydney", 100);
		hp.put("wales", 50);
		hp.put("Texas44", 200);
		hp.put("califorrrnia", 300);
		hp.put("maldives4", 400);
		hp.put("sydney4", 100);
		hp.put("wales44", 50);

		return hp;

	}

	public HashMap<String, Integer> getUnsortedMap1() {

		HashMap<String, Integer> hp = new HashMap<String, Integer>();

		hp.put("Texas1", 12);
		hp.put("california1", 784);
		hp.put("maldives1", 400);
		hp.put("sydney1", 200);
		hp.put("wales3", 50);

		return hp;

	}

	//@SuppressWarnings("unlikely-arg-type")
	public Map<String, LinkedHashMap<String, Integer>> getTop50Repos(String city, int limit) {

		Map<String, LinkedHashMap<String, Integer>> mapmap = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
		
		Map<String, Integer> res;
		HashMap<String, Integer> unsorted = getUnsortedMap();
		HashMap<String, Integer> unsorted1 = getUnsortedMap1();
		LinkedHashMap<String, Integer> sortedorde = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, Integer> reverseorder = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, Integer> sortedorde1 = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, Integer> reverseorder1 = new LinkedHashMap<String, Integer>();
		//ArrayList<>

		if (limit <= 50) {

			unsorted.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.forEachOrdered(x -> sortedorde.put(x.getKey(), x.getValue()));
			System.out.println(sortedorde);

			sortedorde.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(limit)
					.forEachOrdered(x -> reverseorder.put(x.getKey(), x.getValue()));
			System.out.println(reverseorder);
			

		} else {

			unsorted1.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.forEachOrdered(x -> sortedorde1.put(x.getKey(), x.getValue()));
			

			sortedorde1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(limit)
					.forEachOrdered(x -> reverseorder1.put(x.getKey(), x.getValue()));

		}

	     mapmap.put(city, reverseorder);
	     System.out.println(mapmap);
		mapmap.put(city, reverseorder1);
		System.out.println(mapmap.get(city));
		System.out.println(mapmap.values());
Collection<LinkedHashMap<String, Integer>>  res11=	       mapmap.values();
System.out.println(res11.toString());
		System.out.println(mapmap.values());
	//	System.out.println(mapmap.entrySet().stream().forEach(mapmap));
		if (mapmap.containsKey(city.equalsIgnoreCase("Newyork"))) {
			
		res=	mapmap.get(city);
		System.out.println("came"+res);
		}
		else {
		
		res=	mapmap.get(city);
		}
		return mapmap;

	}

}
