package Ctrllpkg;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Beanpakg.Beanclls;
import Daoopkg.Daoocls;



@Controller

public class Ctrllcls {
	
	@Autowired
	Daoocls dao;

	@RequestMapping("/userregistration.html")//redirect to userregistrtion page
	public String index()
	{
		return "Userregistration";
		
	}
	
	@RequestMapping("/Register.html")//redirect to login page user registration
	public String userregister(Beanclls b)
	{
		dao.userregister(b);
		return "Login";
	}
	
	@RequestMapping("/login.html")//redirect to login page form index page
	public String login()
	{
		return "Login";
	}
	
	@RequestMapping("/Loginaction.html")//redirect to home pages of admin or user after login 
	public String loginaction(Beanclls bean,HttpSession hs,Model m)
	{
		List<Beanclls>l=dao.loginaction(bean);
	    
		if(l.size()>0)
		{
			System.out.println(l.size());
			for(Beanclls b:l)
			{
				hs.setAttribute("userid", b.getId());
				hs.setAttribute("userfirstname",b.getFirstname());
				hs.setAttribute("userlastname",b.getLastname());
				hs.setAttribute("userphnno",b.getPhnno());
				hs.setAttribute("useremail",b.getEmail());
				hs.setAttribute("userusername",b.getUsername());
				
				
			}
			return "Userhome";
		}
		else if(bean.getUsername().equals("admin") && bean.getPassword().equals("admin111"))
		{
			return "Adminhome";
		}
		else
		{
			m.addAttribute("err","User name or password error");//error message
			return "Login"; 
		}			
	}
	
	@RequestMapping("/addproducts.html")//redirect to Adminaddproducts page
	public String products()
	{
		return "Adminaddproducts";
		
	}
	
	@RequestMapping(value="/productsadd.html",method=RequestMethod.POST)//Admin Adding products
	public String productsadd(Beanclls b,Model m,@RequestParam("pimage")MultipartFile pimage) throws IOException
	{
		dao.productsadd(b,pimage);
		m.addAttribute("suc","Successfully added");//success message
		return "Adminaddproducts";
	}
	

	
	
	@RequestMapping("/listproducts.html")//view products
	public String viewproduct(Model m)
	{
		List<Beanclls>l=dao.viewproduct();
		m.addAttribute("list",l);
		return "Userviewproduct";
	}
	
	@RequestMapping(value = "/getimage.html")//fetching image from data base
	public void getimage(HttpServletResponse response, @RequestParam("pid") int pid) throws Exception {
		response.setContentType("image/jpeg");
		Blob ph = dao.getimage(pid) ;
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	

	@RequestMapping("/more.html")//redirect to moreinfo page
	public String moreinfo(@RequestParam("pid")int pid,Model m)
	{
		List<Beanclls>l=dao.moreinfo(pid);
		m.addAttribute("list",l);
		return "Moreinfo";
	}
	@RequestMapping(value = "/getmoreimage.html")//fetching image for moreinfo page
	public void get(HttpServletResponse response, @RequestParam("pid") int pid) throws Exception {
		response.setContentType("image/jpeg");
		Blob ph = dao.getimage(pid) ;
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@RequestMapping("/back1.html")//redirect to admin home page
	public String back1(HttpSession h)
	{
		h.setAttribute("name","username");
		return "Adminhome";
	}
	
	@RequestMapping("/back2.html")//redirect to user home page
	public String back2()
	{
		return "Userhome";
	}
}
