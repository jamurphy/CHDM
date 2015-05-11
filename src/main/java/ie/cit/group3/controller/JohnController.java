package ie.cit.group3.controller;

/**
 * @author John Stevens
 * Student Id: R00119235
 * Date: 	May 2015
 * This is my initial view controller 
 */



import java.util.List;

import ie.cit.group3.JdbcTemplateTestApplication;
import ie.cit.group3.entity.GameType;
import ie.cit.group3.repository.GameTypeRepository;
import ie.cit.group3.service.GameTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gamification")

public class JohnController 
{
	
	@Autowired
	GameTypeRepository gametype;
	
	
	@RequestMapping(value="/admin/gametype", method = RequestMethod.GET) 
	public String listAll(ModelMap model) 
	{			
			
			List<GameType> listgametype = (List<GameType>) gametype.findAll();
			model.addAttribute("gametype", listgametype);
		    return "displayGamePointsAdmin";			
	}  
	
	@RequestMapping(value="/XXXX/{id}", method = RequestMethod.GET) 
	public ModelAndView UpdatePoints(@PathVariable int id, ModelMap model) 
	{			
		return new ModelAndView("displayGamePointsAdmin", "game", new GameType());	
					
	}  
	
	@RequestMapping(value="/XXXX/{id}", method = RequestMethod.POST) 
	public String UpdatePost(@ModelAttribute ("gametype") GameType game, ModelMap model, @PathVariable int id)
	{
		GameType g = gametype.findOne(id);
		System.out.println(g);
		
		g.setGamepoints(game.getGamepoints());
		gametype.save(g);
		
		List<GameType> listgametype = (List<GameType>) gametype.findAll();
		model.addAttribute("gametype", listgametype);
	    return "displayGamePointsAdmin";
		
	}
	
  
	
}  

