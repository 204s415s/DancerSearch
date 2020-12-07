package search.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import search.entity.Dancer;
import search.entity.Search;
import search.entity.Week;
import search.repository.DancerRepository;
import search.repository.SearchRepository;
import search.repository.StudioRepository;
import search.repository.WeekRepository;
import search.specifications.SearchSpecifications;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	
	@Autowired
	SearchRepository searchRepository;
	@Autowired
	DancerRepository dancerRepository;
	@Autowired
	StudioRepository studioRepository;
	@Autowired
	WeekRepository weekRepository;
	
	//Combine search criteria
	public List<Search> findSearch(String dancer, String team, String studio, String week
			, BigDecimal startFrom, BigDecimal startTo, BigDecimal closeFrom, BigDecimal closeTo, String level) {
	    return searchRepository.findAll(Specification
	        .where(SearchSpecifications.dancerContains(dancer))
	        .and(SearchSpecifications.teamContains(team))
	        .and(SearchSpecifications.studioContains(studio))
	        .and(SearchSpecifications.weekContains(week))
	        .and(SearchSpecifications.startGreaterThanEqual(startFrom))
	        .and(SearchSpecifications.startLessThanEqual(startTo))
	        .and(SearchSpecifications.closeGreaterThanEqual(closeFrom))
	        .and(SearchSpecifications.closeLessThanEqual(closeTo))
	        .and(SearchSpecifications.levelContains(level))	   
	    );
	}
	
	//Extract dancer detailed output information from the dancer table
	 public Dancer findById(String dancerCode) {
		    Optional<Dancer> dancer = dancerRepository.findById(dancerCode);
		    return dancer.get();
		  }
	
	 public List<Studio> findAllStudio() {
		 return studioRepository.findAll();
	 }
	 
	 public List<Week> findAllWeek() {
		 return weekRepository.findAll();
	 }
}
