package Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import Model.UserModel;
import Model.use;
import helper.HiberHelper;
@Controller
public class UserController {
	HiberHelper db= new HiberHelper();
	@RequestMapping("rgstr")
	public String rgstr() {  
		
		return "index";

	}
	
	@RequestMapping("userload")
	public ModelAndView userload() {  
		
		return new ModelAndView("userview","command",new UserModel());
	}
	@RequestMapping("usercode")
	public ModelAndView usercode(@ModelAttribute("xyz")use obj,HttpServletRequest req) {
		db.hiberConfigure();
		UserModel us= new UserModel();
		us.setUsername(obj.getUsername());
		us.setPassword(obj.getPassword());
		us.setEmail(obj.getEmail());
		us.setMobile(obj.getMobile());
		db.insertData(us);
		return new ModelAndView("userview","command",new UserModel()).addObject("key","Succese Full");

	}
	@RequestMapping("viewstu")
	public ModelAndView viewstu()
	{
		db.hiberConfigure();
		List lst = db.getData("from UserModel s");
		return new ModelAndView("showadmin","command",new UserModel()).addObject("key1",lst);
		
	}
	@RequestMapping("edituser")
	public ModelAndView edituser(HttpServletRequest request)
	{
		db.hiberConfigure();
		UserModel o =(UserModel) db.findData(UserModel.class,(request.getParameter("q")));
		List lst = db.getData("from UserModel s");
		ModelAndView mo= new ModelAndView("approved","command",o);
		mo.addObject("key1",lst);
		mo.addObject("btnkey","update");
		return mo;
	}
	@RequestMapping("edituser1")
	public ModelAndView edituser1(HttpServletRequest request)
	{
		db.hiberConfigure();
		UserModel o =(UserModel) db.findData(UserModel.class,(request.getParameter("q")));
		List lst = db.getData("from UserModel s");
		ModelAndView mo= new ModelAndView("Block","command",o);
		mo.addObject("key1",lst);
		mo.addObject("btnkey","update");
		return mo;
	}

	@RequestMapping("update1")
	   public ModelAndView update1(@ModelAttribute("xyz")UserModel obj,HttpServletRequest req)
	   {
		 db.hiberConfigure();
		 UserModel um  = new UserModel();
		   um.setUsername(obj.getUsername());
		   um.setPassword(obj.getPassword());
		   um.setEmail(obj.getEmail());
		   um.setMobile(obj.getMobile());
		   um.setStatus(obj.getStatus());
		   db.updateData(um);
		   return new ModelAndView("redirect:viewstu.html");
		   //return new ModelAndView("vieww","command",new reg());

}
	@RequestMapping("update2")
	public ModelAndView update2(@ModelAttribute("xyz")UserModel obj,HttpServletRequest req) {
		db.hiberConfigure();
		UserModel us= new UserModel();
		us.setUsername(obj.getUsername());
		us.setPassword(obj.getPassword());
		us.setEmail(obj.getEmail());
		us.setMobile(obj.getMobile());
		us.setStatus(obj.getStatus());
		db.updateData(us);
		return new ModelAndView("redirect:viewstu.html");
	}	
	@RequestMapping("checkuserinfo")
	public ModelAndView checkuserinfo(HttpServletRequest request) {
		db.hiberConfigure();
		Object o= db.findData(UserModel.class,(request.getParameter("q")));
	if(o!=null) {
		return new ModelAndView("infoview","key","useralready exit");
		
	}
	else {
		return new ModelAndView("infoview","key","not exit");
		
	}
	
	}
	@RequestMapping("homecode")
	public ModelAndView homecode(@ModelAttribute("xyz")UserModel obj,HttpServletRequest req) {
		db.hiberConfigure();
		return new ModelAndView("index");
		
	}
}