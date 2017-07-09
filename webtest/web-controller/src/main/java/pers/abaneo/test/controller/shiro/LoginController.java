package pers.abaneo.test.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class LoginController {
	
	@ResponseBody
	@RequestMapping("login")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password){
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject=SecurityUtils.getSubject();
		subject.login(token);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("logout")
	public String logout(){
		Subject subject=SecurityUtils.getSubject();
		subject.logout();
		return "success";
	}
}
