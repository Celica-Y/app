package com.example.demo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@SessionAttributes()
public class cookieController {
//cookie

	@RequestMapping(value="/index/key1", method=RequestMethod.GET)
	public ModelAndView Get(ModelAndView mv,HttpServletResponse response) {
		Cookie a = new Cookie("key1","value3");
		response.addCookie(a);
		mv.addObject(response);
		mv.setViewName("index"); 
		System.out.println();
		return mv;
	}
	@RequestMapping(value="/index/key2", method=RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv,HttpServletResponse response) {
		Cookie a = new Cookie("key2","value4");
//		key1とういう名前にvalue4という変数が代入されている
		response.addCookie(a);
		mv.addObject(response);
		mv.setViewName("index"); 
		System.out.println(a);
//		上だとなんか文字列がコンソールに表示される
		return mv;
	}
	
	
	
//	画面上での取得言葉のセット
//	@RequestMapping(value="/set", method=RequestMethod.GET)
//	public ModelAndView SetGet(ModelAndView mv,@CookieValue(value = "word", defaultValue="someValue") String word) {
//		
//		mv.addObject("text",word);
//		mv.setViewName("setting"); 
//		return mv;
//	}
//
//	@RequestMapping(value="/set", method=RequestMethod.POST)
//	public ModelAndView settingPost(@RequestParam("form") String word,
//			HttpServletResponse response,ModelAndView mv) {
//		
//		Cookie c = new Cookie("word", word);
//		response.addCookie(c);
//		
//		mv.addObject(response);
//		mv.setViewName("setting"); 
////		System.out.print(word);
//		return new ModelAndView("redirect:/set");
//	}
//	クッキーの取得
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView iGet(ModelAndView mv,
	HttpServletResponse response,
	@CookieValue(value="key2") String cookieValue) {

		mv.setViewName("index"); 
		System.out.println(cookieValue);
		return mv;
	}

//セッション	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/session", method=RequestMethod.GET)
	public ModelAndView saveGet(ModelAndView mv) {
	   session.setAttribute("data","some");
	   mv.addObject(session);
	   mv.setViewName("session");
	   return mv;
	}
	@RequestMapping(value = "/get", method=RequestMethod.GET)
	public ModelAndView sGet(ModelAndView mv) {
	   Object data = session.getAttribute("data");	   
	   System.out.println(data);
	  
	   String Id = session.getId();
	   System.out.println(Id);
	   
	   mv.setViewName("session");
	   return mv;
	}
	
	
	
}


