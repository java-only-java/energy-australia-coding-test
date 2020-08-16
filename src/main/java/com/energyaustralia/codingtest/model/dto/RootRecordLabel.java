package com.energyaustralia.codingtest.model.dto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class RootRecordLabel {
	
	public Map<String, Map <String, List<String>>> recordLabels;
	
	

	public RootRecordLabel() {
		
		this.recordLabels = new TreeMap<String, Map <String, List<String>>>();
	}

	public Map<String, Map<String, List<String>>> getRecordLabels() {
		return recordLabels;
	}

	public void setRecordLabels(Map<String, Map<String, List<String>>> recordLabels) {
		this.recordLabels = recordLabels;
	}
	
	
	
	

}
