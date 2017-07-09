package pers.abaneo.test.controller.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody()
public class AuthTestController {

	@RequestMapping("admin/req")
	public String admin(){
		return "admin";
	}
	
	@RequestMapping("shopper/")
	public String shopper(){
		return "shopper";
	}
	
	@RequestMapping("testAnd")
	public String adminAndShop(){
		return "adminAndShop";
	}
	
	@RequestMapping("testOr")
	public String adminOrShop(){
		return "adminOrShop";
	}
}
