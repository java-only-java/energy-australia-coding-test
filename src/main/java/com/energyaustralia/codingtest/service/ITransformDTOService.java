package com.energyaustralia.codingtest.service;

import com.energyaustralia.codingtest.model.MusicFestival;
import com.energyaustralia.codingtest.model.dto.RecordLabel;

import reactor.core.publisher.Mono;

public interface ITransformDTOService {

	Mono<String> transformDTO(Mono<MusicFestival[]> allMusicFestivals);

}
