package com.lzp.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/loginAction")
public class LoginAction {

	@RequestMapping(value = "/login")
	public String login(String usercode,String password) {
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(new UsernamePasswordToken(usercode, password.toCharArray()));
			return "main/main";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
