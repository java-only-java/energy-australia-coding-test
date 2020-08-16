package com.energyaustralia.codingtest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyaustralia.codingtest.model.Band;
import com.energyaustralia.codingtest.model.MusicFestival;
import com.energyaustralia.codingtest.model.dto.RecordLabel;
import com.energyaustralia.codingtest.model.dto.RootRecordLabel;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Service
public class TransformDTOService implements ITransformDTOService {

	@Autowired
	RootRecordLabel rootRecordLabel;

	String expectedReturnFormat;

	@Override
	public Mono<String> transformDTO(Mono<MusicFestival[]> allMusicFestivals) {
		allMusicFestivals.map(musicFestivals -> convertMusicFestivalToRecordLabel(musicFestivals)).block();
		return Mono.just(expectedReturnFormat);
	}

	public String convertMusicFestivalToRecordLabel(MusicFestival[] musicFestivals) {
		Map<String, Map<String, List<String>>> recordLabels = rootRecordLabel.getRecordLabels();
		Map<String, List<String>> bandMap = new TreeMap<String, List<String>>();
		List<String> musicFestivalNames = new ArrayList<String>();
		for (MusicFestival musicFestival : musicFestivals) {
			String musicFestivalName = musicFestival.getName();
			if (musicFestivalName != null && musicFestivalName.length() > 0) {
				musicFestivalNames.add(musicFestivalName);
				Collections.sort(musicFestivalNames);
				List<Band> bands = musicFestival.getBands();
				for (Band band : bands) {
					String bandName = band.getName();
					String recordLabel = band.getRecordLabel();
					if (bandName != null && bandName.length() > 0) {
						bandMap.put(bandName, musicFestivalNames);
						if (recordLabel != null && recordLabel.length() > 0) {
							recordLabels.put(recordLabel, bandMap);
						}
					}
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Map<String, List<String>>> recordLabelEntry : recordLabels.entrySet()) {

			sb.append(recordLabelEntry.getKey());
			Map<String, List<String>> recordLabelEntryValue = recordLabelEntry.getValue();
			sb.append("\r\n");
			for (Map.Entry<String, List<String>> bandEntry : recordLabelEntryValue.entrySet()) {
				sb.append("    " + bandEntry.getKey());
				sb.append("\r\n");
				List<String> festivalNames = bandEntry.getValue();
				for (String musicFestivalName : festivalNames) {
					sb.append("              " + musicFestivalName);
					sb.append("\r\n");
				}
			}

		}
		System.out.println(sb.toString()); // the expected solution or output format will be printed on the server
											// terminal.
		expectedReturnFormat = sb.toString();
		return sb.toString();

	}

}
