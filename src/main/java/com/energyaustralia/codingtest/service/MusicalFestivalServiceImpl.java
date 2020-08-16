package com.energyaustralia.codingtest.service;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.energyaustralia.codingtest.model.MusicFestival;
import com.energyaustralia.codingtest.model.RootMusicFestival;

import reactor.core.publisher.Mono;

@Service
public class MusicalFestivalServiceImpl implements IMusicFestivalService {

	@Override
	public Mono<MusicFestival[]> getAllMusicFestivals() {
		  return createWebClientWithServerURLAndDefaultValues().get()
			        .uri("/api/v1/festivals")
			        .retrieve()
			        .bodyToMono(MusicFestival[].class);
		 
	}
	
	private WebClient createWebClientWithServerURLAndDefaultValues() {
        return WebClient.builder()
            .baseUrl("http://eacodingtest.digital.energyaustralia.com.au")
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://eacodingtest.digital.energyaustralia.com.au"))
            .build();
    }


}
