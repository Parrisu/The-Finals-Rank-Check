package com.parrisu.finals.services;

import com.parrisu.finals.entities.Contestant;

public interface ContestantService {
	
	Contestant Update(Contestant contestant);
	
	Contestant getContestantByEmbarkName(String embarkName);
	
	

}
