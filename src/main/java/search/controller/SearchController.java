package search.controller;

import java.math.BigDecimal;
import java.util.List;

import search.entity.Dancer;
import search.entity.Search;
import search.repository.SearchRepository;
import search.repository.DancerRepository;
import search.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@ComponentScan
@Controller
@SessionAttributes("searchForm")
public class SearchController {
	
	@Autowired
	public SearchService searchService;
	@Autowired
	public SearchRepository searchRepository; 
	@Autowired
	public DancerRepository dancerRepository;

	//Search screen
    @RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
    
	//search results	
  	@RequestMapping(value = "/index/search", method = RequestMethod.GET)
	public ModelAndView search(ModelAndView mav
			, @RequestParam("dancer") String dancer, @RequestParam("team") String team
			, @RequestParam(name="studio", required=false) String studio
			, @RequestParam(name="week", required=false) String week, @RequestParam(name="start", required=false) BigDecimal start
			, @RequestParam(name="startFrom", required=false) BigDecimal startFrom, @RequestParam(name="startTo", required=false) BigDecimal startTo
			, @RequestParam(name="closeFrom", required=false) BigDecimal closeFrom, @RequestParam(name="closeTo", required=false) BigDecimal closeTo
			, @RequestParam("level") String level) {
  		mav.setViewName("search");
		mav.addObject("dancer", dancer);
		mav.addObject("team", team);
		mav.addObject("studio", studio);
		mav.addObject("week", week);
		mav.addObject("startFrom", startFrom);
		mav.addObject("startTo", startTo);
		mav.addObject("closeFrom", closeFrom);
		mav.addObject("closeTo", closeTo);
		mav.addObject("level", level);
		List<Search> result = searchService.findSearch(dancer, team, studio, week, startFrom, startTo, closeFrom, closeTo, level);
		mav.addObject("result", result);
		mav.addObject("resultSize", result.size());
		return mav;
	}

  	//Dancer details page
	@RequestMapping(value="/dancer/{dancerCode}", method = RequestMethod.GET)
	public ModelAndView dancer(@PathVariable("dancerCode") String dancerCode, @RequestParam(name="name", required=false) String name
			,@RequestParam(name="team", required=false) String team, @RequestParam(name="movie", required=false) String movie,
			ModelAndView mav) {
		mav.setViewName("dancer");
		mav.addObject("name", name);
		mav.addObject("team", team);
		mav.addObject("movie", movie);
		Dancer dancer = searchService.findById(dancerCode);
		mav.addObject("dancer", dancer);
		return mav;
	}
}
