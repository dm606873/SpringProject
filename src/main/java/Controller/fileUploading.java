package Controller;
import java.io.*;

import javax.persistence.Entity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
@Entity
public class fileUploading {
	
	@RequestMapping("/upload")
	public ModelAndView uploadview()
	{
		return new ModelAndView("uploadform");
	}
	@RequestMapping("/uploadlogic")
	public ModelAndView uploadlogic(@RequestParam CommonsMultipartFile file,HttpSession session) throws IOException
	{
	
		String path= session.getServletContext().getRealPath("/")+"images";  
        String filename=file.getOriginalFilename();  
        System.out.println(path+""+filename);        
  	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path+""+filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return new ModelAndView("Showfile","filesuccess",filename);  
    }
	
	
}