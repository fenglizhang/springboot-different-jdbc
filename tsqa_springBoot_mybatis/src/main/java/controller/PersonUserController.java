package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.IPersonUserService;
import domain.PersonUserBo;

@Controller
@RequestMapping("/personUser")
public class PersonUserController {
	@Autowired
	IPersonUserService personUserService;
	
	@ResponseBody
	@RequestMapping(path="/totalList")
	public List<PersonUserBo> queryPersonUserList(){
		return personUserService.getAllList();
	}
	
}
