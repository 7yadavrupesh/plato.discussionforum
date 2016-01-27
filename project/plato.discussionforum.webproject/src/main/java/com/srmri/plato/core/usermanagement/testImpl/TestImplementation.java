package main.java.com.srmri.plato.core.usermanagement.testImpl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;
import main.java.com.srmri.plato.core.usermanagement.service.UmFacultyService;
import main.java.com.srmri.plato.core.usermanagement.service.UmStudentService;
import main.java.com.srmri.plato.core.usermanagement.service.UmUserDetailsService;


public class TestImplementation 
{
	
    public static void main( String[] args ) throws IOException, ParseException
    {
    	@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("main/java/resources/applicationContext.xml");
         
    	UmUserDetailsService userService = (UmUserDetailsService) ctx.getBean("UmUserDetailsService");   
    	
    	UmStudentService studentService = (UmStudentService) ctx.getBean("UmStudentService");
    	
    	UmFacultyService facultyService = (UmFacultyService)ctx.getBean("UmFacultyService");
    	
    	
    	UmUserDetails user = userService.blGetUser("Admin4admin");
    	System.out.println(user.getPassword());
    	System.out.println(user.getUserId());
    	System.out.println(user.getUserName());
    	
    	
    	
    	
    
    	
    
    }
 
}

