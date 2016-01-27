/**********************************************************************************
* File-name - UserManagementController.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: User management controller
**********************************************************************************/


package main.java.com.srmri.plato.core.login.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.srmri.plato.core.rbac.entity.RbacRole;
import com.srmri.plato.core.rbac.entity.RbacRoleAssignment;
import com.srmri.plato.core.rbac.entity.RbacRoleLevel;
import com.srmri.plato.core.rbac.service.RbacRoleAssignmentService;
import com.srmri.plato.core.rbac.service.RbacRoleLevelService;
import com.srmri.plato.core.rbac.service.RbacRoleService;
import main.java.com.srmri.plato.core.login.bean.FacultyBean;
import main.java.com.srmri.plato.core.login.bean.RegisterBean;
import main.java.com.srmri.plato.core.login.bean.StudentBean;
import main.java.com.srmri.plato.core.login.bean.UserBean;
import main.java.com.srmri.plato.core.usermanagement.model.UmDesignation;
import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;
import main.java.com.srmri.plato.core.usermanagement.service.UmDesignationService;
import main.java.com.srmri.plato.core.usermanagement.service.UmFacultyService;
import main.java.com.srmri.plato.core.usermanagement.service.UmStudentService;
import main.java.com.srmri.plato.core.usermanagement.service.UmUserDetailsService;

@Controller
@SessionAttributes(value={"register","user"})
public class UserManagementController 
{
	@Autowired
	private UmUserDetailsService userService;
	@Autowired
	private UmStudentService studentService;
	@Autowired
	private UmFacultyService facultyService;
	@Autowired
	private UmDesignationService designationService;
	@Autowired
	private RbacRoleLevelService roleLevelService;
	@Autowired
	private RbacRoleService roleService;
	@Autowired
	private RbacRoleAssignmentService roleAssignmentService;
	@Autowired
	private MailSender mailSender;
	
	
	/**
	 * Controller for showing student list
	 * @return View page for student list
	 */
	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public ModelAndView studentList()
	{
		HashMap<String, Object> model = new HashMap<String, Object>();
		
		List<UmStudent> studentList = studentService.blListStudents();
		List<RbacRole> roleList = roleService.rbacBsListRoles();
		model.put("studentList", studentList);
		model.put("roleList", roleList);
		return new ModelAndView("studentList", model);
	}
	
	/**
	 * Controller for showing faculty list
	 * @return View page for faculty list
	 */
	@RequestMapping(value = "/facultyList", method = RequestMethod.GET)
	public ModelAndView facultyList()
	{
		HashMap<String, Object> model = new HashMap<String, Object>();
		
		List<UmFaculty> facultyList = facultyService.blListFaculties();
		
		List<RbacRole> roleList = roleService.rbacBsListRoles();
		
		HashMap<Long, String> facultyDetails = new HashMap<Long, String>();
		
		for(UmFaculty faculty: facultyList)
		{
			
			UmDesignation designation = designationService.blGetDesignation(faculty.getDesignationId());
			String desName = designation.getDesignationName();
			System.out.println(desName);
			facultyDetails.put(faculty.getFacultyId(), desName);
			
		}
		
		model.put("facultyList", facultyList);
		model.put("facultyDetails", facultyDetails);
		model.put("roleList", roleList);
		
		return new ModelAndView("facultyList", model);
	}
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@ModelAttribute("user") UserBean userBean)
	{
		HashMap<String, Object> model = new HashMap<String, Object>();
		String roleName = userBean.getRole();
		
		String[] tokens = roleName.split(",", -1);
		
		RbacRole role = roleService.rbacBsGetRole(Integer.parseInt(tokens[0]));
		
		RbacRoleLevel roleLevel = roleLevelService.rbacBsGetRoleLevel(role.getRoleLevelId());
        
		String rlName = roleLevel.getRoleLevelName();

		
		userBean.setRoleId(Integer.parseInt(tokens[0]));
		
		UmUserDetails user = userService.blGetUser(userBean.getUserId());
		String imagePath = user.getImage();
		
		model.put("roleLevel", rlName);	
		model.put("profile_image", imagePath);
		model.put("userid", userBean.getUserId());
		model.put("username", userBean.getUserName());
		model.put("email", user.getEmailId());
		model.put("role", tokens[1]);

		return new ModelAndView("profile", model);
	}
	
	
	/**
	 ********************Register functions****************************
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() throws IOException 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		List<RbacRole> roleList = roleService.rbacBsListRoles();
		
		model.put("roleList",  roleList);
		
		return new ModelAndView("register", model);
	}
		
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateRegister(@ModelAttribute("register") @Valid RegisterBean regBean,BindingResult result,  RedirectAttributes attr)
	{
		if (result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<ObjectError> error = result.getAllErrors();
			
			
			for(ObjectError err: error)
			{
				System.out.println(err.toString());
			}
			
		  attr.addFlashAttribute("org.springframework.validation.BindingResult.register", result);
		  attr.addFlashAttribute("register", regBean);
		   
		   return "redirect:register.html";
			
		}
		
		else
		{
			String[] tokens = regBean.getRole().split(",", -1);
			
			
			regBean.setRoleId(Integer.parseInt(tokens[0]));
			regBean.setRoleName(tokens[1]);
			
			RbacRole role = roleService.rbacBsGetRole(regBean.getRoleId());
			
			RbacRoleLevel roleLevel = roleLevelService.rbacBsGetRoleLevel(role.getRoleLevelId());
			
			String rlName = roleLevel.getRoleLevelName();
					
			
			if(rlName.equals("Student"))
				return "redirect:addstudent.html";
			else if(rlName.equals("Teaching"))
				return "redirect:addfaculty.html";
			else
			{
				return "redirect:addadmin.html";
			}
				
		}
		
	}
	
	
	public void sendMail(String from, String to, String subject, String msg) 
	{

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);   
    }

	/**
	 ******************************************************************
	 */
	
	
	/**
	 ***********************User add functions********************************
	 */
	
	@RequestMapping(value = "/addadmin", method = RequestMethod.GET)
    public ModelAndView addAdmin(@ModelAttribute("register") @Valid RegisterBean regBean,BindingResult result) throws IOException, ParseException
    {
		boolean success = false;
		
		MultipartFile file = null;	
		
		byte[] bytes = null;
		
		File serverFile = null;
		
		String key = userService.randomPasswordGenerator(20);
		String password = userService.generateHashedPassword(key);
		
		try	
		{  
			
			file = regBean.getImage();
			regBean.setImageName(file.getOriginalFilename());
			bytes = file.getBytes();
								
			String rootPath = System.getProperty("user.dir");
			
			File dir = new File(rootPath+File.separator+"tmpFiles");
				
			
			if (!dir.exists())
                  dir.mkdirs();
				
			serverFile = new File(dir.getAbsolutePath()+File.separator+file.getOriginalFilename());
			
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            regBean.setImageUploadPath(serverFile.getAbsolutePath()+file.getOriginalFilename());
                
		}
		catch(Exception e)
		{
			System.out.println("exception in stream");
			System.out.println(e.getMessage());
		}
					
		UmUserDetails user = (UmUserDetails)regBean.prepareModel(password);
		
		try
		{	success = userService.blAddUser(user);}
		catch(Exception e)
		{	success = false;}
				
		HashMap<String, Object> model1 = new HashMap<String, Object>();
		if(success)
		{
			
			
			RbacRoleAssignment roleAssignment = new RbacRoleAssignment();
			
			roleAssignment.setRoleId(regBean.getRoleId());
			roleAssignment.setUserId(user.getUserId());
			
			roleAssignmentService.rbacBsAddRoleAssignment(roleAssignment);
			
			model1.put("val", "successful");
			model1.put("username", user.getUserName());
			
			
			//Send email
			String sender="srmtestingplato@gmail.com";
			String passwordDetails = "<p>You have been successfully registered</p><br/> Your password is "+key;
			try
			{
				this.sendMail(sender, user.getEmailId(), "Registeration Successfull", passwordDetails);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		else
		model1.put("val", "failed");
		return new ModelAndView("useradded", model1);
	}
	
			
	@RequestMapping(value = "/addfaculty", method = RequestMethod.GET)
    public ModelAndView addFaculty() 
    {
		HashMap<String, Object> model = new HashMap<String, Object>();
			
		List<UmDesignation> designationList = designationService.blListDesignations();
			
		model.put("designationList",  designationList);
			
		return new ModelAndView("addfaculty", model);
		
    }
		
	@RequestMapping(value = "/facultyadded", method = RequestMethod.POST)
	public Object facultyAdded(@ModelAttribute("register") RegisterBean regBean, @ModelAttribute("faculty") @Valid FacultyBean facultyBean, BindingResult result, RedirectAttributes attr)
	{
		if (result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<ObjectError> error = result.getAllErrors();
			
			
			for(ObjectError err: error)
				System.out.println(err.toString());
						
			attr.addFlashAttribute("org.springframework.validation.BindingResult.faculty", result);
			attr.addFlashAttribute("faculty", facultyBean);
			
					   
			return "redirect:addfaculty.html";
			
		}
		else
		{
			boolean success = false;
			
			long userId = 0;
			
			String key = userService.randomPasswordGenerator(20);
			String password = userService.generateHashedPassword(key);
			
			try
			{
				facultyBean.setDesignationId(designationService.blGetDesignationId(facultyBean.getDesignation()));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
					
			
			try
			{
						
			  UmFaculty faculty = (UmFaculty)facultyBean.prepareModel(regBean);
			  success = facultyService.blAddFaculty(faculty);
			  userId = faculty.getUserId();
				
			  UmUserDetails user = userService.blGetUser(userId);
			  user.setPassword(password);
			  userService.blAddUser(user);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				success = false;
			}
			
			HashMap<String, Object> newModel = new HashMap<String, Object>();
			if(success)
			{
				RbacRoleAssignment roleAssignment = new RbacRoleAssignment();
				roleAssignment.setRoleId(regBean.getRoleId());
				roleAssignment.setUserId(userId);
				roleAssignmentService.rbacBsAddRoleAssignment(roleAssignment);
				
				newModel.put("val", "successful");
				newModel.put("key", key);
			}
			else
				newModel.put("val", "failed");
			return new ModelAndView("useradded", newModel);
		
		}
	
	}
		
	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
    public ModelAndView addStudent()
    {		
		return new ModelAndView("addstudent");
			
    }
		
	@RequestMapping(value = "/studentadded", method = RequestMethod.POST)
	public Object studentAdded(@ModelAttribute("register") RegisterBean regBean, @ModelAttribute("student") @Valid StudentBean studentBean, BindingResult result, RedirectAttributes attr) throws ParseException, IOException
	{
		if (result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<ObjectError> error = result.getAllErrors();
			
			
			for(ObjectError err: error)
				System.out.println(err.toString());
			
			attr.addFlashAttribute("org.springframework.validation.BindingResult.student", result);
			attr.addFlashAttribute("student", studentBean);
			return "redirect:addstudent.html";
			
		}
		else
		{
			boolean success = false;
						
			long userId = 0;
			
			String key = userService.randomPasswordGenerator(20);
			String password = userService.generateHashedPassword(key);
						
			UmStudent student = (UmStudent)studentBean.prepareModel(regBean);
			
			try
			{				
				success = studentService.blAddStudent(student);
				userId = student.getUserId();
				
				UmUserDetails user = userService.blGetUser(userId);
				user.setPassword(password);
				userService.blAddUser(user);
				
			}
			catch(Exception e)
			{
				success = false;
				System.out.println(e.getMessage());
				
			}
			
			
			HashMap<String, Object> newModel = new HashMap<String, Object>();
			if(success)
			{
				
				
				RbacRoleAssignment roleAssignment = new RbacRoleAssignment();
				roleAssignment.setRoleId(regBean.getRoleId());
				roleAssignment.setUserId(userId);
				
				roleAssignmentService.rbacBsAddRoleAssignment(roleAssignment);
				
				newModel.put("val", "successful");
				newModel.put("key", key);
			}
			else
				newModel.put("val", "failed");
			return new ModelAndView("useradded", newModel);
						
		}
		
	}
	
	/**
	 **********************************************************************
	 */

}
