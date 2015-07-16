package com.lzp.web;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAction {

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping(value = "/json1", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> json1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", true);
		return map;
	}
	
	@RequestMapping(value = "/json2", method = RequestMethod.GET)
	@ResponseBody
	public List<String> list() {
		List<String> list = new LinkedList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}

	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("message", "Hello main!");
		return "main";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("message", "Hello login!");
		return "login";
	}
}
