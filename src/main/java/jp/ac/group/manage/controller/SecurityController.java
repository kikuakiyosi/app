package jp.ac.group.manage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SecurityController{
	
@RequestMapping("/")
public ModelAndView index (ModelAndView mav) { 
	mav.setViewName("index"); 
	mav.addObject("title", "在庫管理サイト");
	mav.addObject("msg", "by岡田純弥"); 
	return mav;
}
@RequestMapping("/secret")
public ModelAndView secret (ModelAndView mav, HttpServletRequest request) {
String user = request.getRemoteUser();
String msg = "This is secret page. [login by \"" + user + "\"]";
mav.setViewName("Secret");
mav.addObject("title", "Secret page");
mav.addObject("msg", msg);
return mav;
}

@RequestMapping("/admin")
public ModelAndView admin(ModelAndView mav) {
mav.setViewName("index");
mav.addObject("title", "Admin page");
mav.addObject("msg", "This is only access ADMIN!");
return mav;
}

}