package com.energyaustralia.codingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energyaustralia.codingtest.model.MusicFestival;
import com.energyaustralia.codingtest.service.IMusicFestivalService;
import com.energyaustralia.codingtest.service.ITransformDTOService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class MusicFestivalDataRestAPIController {
	
	@Autowired
    private IMusicFestivalService musicFestivalService;
	
	@Autowired
    private ITransformDTOService transformDTOService;
	
	String returnedFormat ;
 	// The return format and solution will be published on the -> http://localhost:8080/api/v1/eamusicfestivals
	
						    /*ACR
							     Adrian Venti
							              Trainerella
							     Manish Ditch
							              Trainerella
							     Wild Antelope
							              Trainerella
							     YOUKRANE
							              Trainerella
							Anti Records
							    Adrian Venti
							              Trainerella
							    Manish Ditch
							              Trainerella
							    Wild Antelope
							              Trainerella
							    YOUKRANE
							              Trainerella
							Monocracy Records
							    Adrian Venti
							              Trainerella
							    Manish Ditch
							              Trainerella
							    Wild Antelope
							              Trainerella
							    YOUKRANE
							              Trainerella
							Still Bottom Records
							    Adrian Venti
							              Trainerella
							    Manish Ditch
							              Trainerella
							    Wild Antelope
							              Trainerella
							    YOUKRANE
							              Trainerella*/
	
    @GetMapping(value="/eamusicfestivals", produces = MediaType.TEXT_PLAIN_VALUE)
    public String findAllMusicFestivals() {
          Mono<MusicFestival[]> allMusicFestivals = musicFestivalService.getAllMusicFestivals();
          transformDTOService.transformDTO(allMusicFestivals).subscribe(result -> assign(result));
          return returnedFormat;
    }


	private void assign(String result) {
		this.returnedFormat = result;
		 
	}

}
