package pers.abaneo.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	@ResponseBody
	@RequestMapping("")
	public String test(){
		return "hello world";
	}
	@ResponseBody
	@RequestMapping("/ajax")
	public Map<String, String> ajax(){
		Map<String, String> map=new HashMap<>();
		map.put("message", "hello world");
		return map;
	}
	@ResponseBody
	@RequestMapping("/model")
	public Model model(){
		Model model=new Model();
		model.setMessage("hello world");
		return model;
	}
	@RequestMapping("/html")
	public String html(){
		return "index";
	}
}
