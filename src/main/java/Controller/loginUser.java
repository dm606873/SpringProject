package Controller;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import helper.HiberHelper;
import Model.UserModel;


@Controller
public class loginUser {
	HiberHelper db= new HiberHelper();
	@RequestMapping("loginload")
	public ModelAndView login() {
		
		return new ModelAndView("loginview","command",new UserModel());
	}
	@RequestMapping("usershow1")
	public ModelAndView usershow1() {
		
		return new ModelAndView("usershow","command",new UserModel());
	}

	@RequestMapping("logincode")
	public ModelAndView logincode(@ModelAttribute("xyz")UserModel obj, HttpServletRequest request)
	{
		db.hiberConfigure();
		List lst = db.loginData("from UserModel o where o.username=? and o.password=?",obj.getUsername(),obj.getPassword());
		if(lst.size()>0)
		{
			
		 }else {
			 return new ModelAndView("loginview","command",new UserModel()).addObject("key","Invalid Userid and Password");
		 }
		List lst4 = db.loginData1("from UserModel o where o.username=? and o.password=? and o.status=?",obj.getUsername(),obj.getPassword(),1);
		if(lst4.size()>0) {
			  ModelAndView mo = new ModelAndView("usershow","command",new UserModel());
			   mo.addObject("key",lst);
			
			return mo;
		}else {
			return new ModelAndView("loginview","command",new UserModel()).addObject("key","You are Blocked");
		}
	}
	
	@RequestMapping("adminload")
	public ModelAndView admin() {
		
		return new ModelAndView("adminview","command",new UserModel());
	}
	@RequestMapping("showadmin1")
	public ModelAndView showadmin1() {
		
		return new ModelAndView("showadmin","command",new UserModel());
	}

	@RequestMapping("admincode")
	public ModelAndView admincode(@ModelAttribute("xyz")UserModel obj) 
	{
		db.hiberConfigure();
		List lst= db.loginData("from Admin s where s.username=?and s.password=?",obj.getUsername(),obj.getPassword());
		if(lst.size()>0) {
			return new ModelAndView("redirect:viewstu.html");
			
		}
		return new ModelAndView("adminview","commnd",new UserModel()).addObject("key","Invalid user Id or Password");
	}



}
