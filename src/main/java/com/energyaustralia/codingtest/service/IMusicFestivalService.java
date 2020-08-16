package com.energyaustralia.codingtest.service;

import com.energyaustralia.codingtest.model.MusicFestival;
import com.energyaustralia.codingtest.model.RootMusicFestival;

import reactor.core.publisher.Mono;

public interface IMusicFestivalService {
	
	Mono<MusicFestival[]> getAllMusicFestivals();

}
