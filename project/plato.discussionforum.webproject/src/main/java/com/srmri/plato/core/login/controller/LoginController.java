/**********************************************************************************
* File-name - LoginController.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Login controller
**********************************************************************************/


package main.java.com.srmri.plato.core.login.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srmri.plato.core.rbac.entity.RbacRole;
import com.srmri.plato.core.rbac.entity.RbacRoleAssignment;
import com.srmri.plato.core.rbac.entity.RbacRoleLevel;
import com.srmri.plato.core.rbac.service.RbacRoleAssignmentService;
import com.srmri.plato.core.rbac.service.RbacRoleLevelService;
import com.srmri.plato.core.rbac.service.RbacRoleService;

import main.java.com.srmri.plato.core.login.bean.ChangePasswordBean;
import main.java.com.srmri.plato.core.login.bean.EmailBean;
import main.java.com.srmri.plato.core.login.bean.FacultyBean;
import main.java.com.srmri.plato.core.login.bean.RegisterBean;
import main.java.com.srmri.plato.core.login.bean.ResetBean;
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
public class LoginController 
{
	@Autowired
	private UmUserDetailsService userService;
	
	@Autowired
	private RbacRoleLevelService roleLevelService;
	
	@Autowired
	private RbacRoleService roleService;
	
	@Autowired
	private RbacRoleAssignmentService roleAssignmentService;
	
	 
	
	/**
	 *****************Logging functions************************************
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() 
	{		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() 
	{		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(Model map, @ModelAttribute("user") @Valid UserBean userBean, BindingResult result, RedirectAttributes attr)
	{
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<ObjectError> error = result.getAllErrors();
			
			
			for(ObjectError err: error)
			{
				System.out.println(err.toString());
			}
			
		  attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
		  attr.addFlashAttribute("user", userBean);
		   
		   return "redirect:login.html";
			
		}
		
		boolean val = userService.blAuthenticateUser(userBean.getUserName(), userBean.getPassword());
		
		if(val)
		{
		   
		   UmUserDetails user = userService.blGetUser(userBean.getUserName());
		   long userId = user.getUserId();
		   userBean.setUserId(userId);
		   
		   List<RbacRoleAssignment> rolesAss = roleAssignmentService.rbacBsGetUserRoleIds(userId);
		   
		   List<RbacRole> roles = new ArrayList<RbacRole>();
		   
		   for(RbacRoleAssignment rlAss: rolesAss)
		   {
			   RbacRole role = roleService.rbacBsGetRole(rlAss.getRoleId());
			   
			   roles.add(role);
			   
		   }

		   map.addAttribute("roleList", roles);
		   return "authenticate";
		   
		 		   
		}
		else
		{
			map.addAttribute("val", val);	
		
			return "login";
		}
    
	}
	
	@RequestMapping(value = "/authenticateComplete", method = RequestMethod.POST)
    public String authenticateComplete(@ModelAttribute("user") UserBean userBean)
	{
		String roleName = userBean.getRole();
		
		String[] tokens = roleName.split(",", -1);
		
		userBean.setRoleId(Integer.parseInt(tokens[0]));

		return "redirect:listTopic.html";
	
	}
	
	
	@RequestMapping(value = "/logout")
	public String logout(Model model, @ModelAttribute("user") UserBean userBean,  HttpSession session, SessionStatus status)
	{	
	    session.invalidate();
       
        userBean = null;
        
		return "login";
	
	}
	
	/**
	 ******************************************************************
	 */
	
	
	/**
	 **********************Change Password functions************************
	 */
	@RequestMapping(value = "/forgotPassword",  method = RequestMethod.GET)
    public ModelAndView forgotPassword()
	{
		return new ModelAndView("forgotPassword");
	}
	
	@RequestMapping(value = "/resetPassword",  method = RequestMethod.POST)
    public String resetPassword(Model map, @ModelAttribute("email") @Valid EmailBean emailBean, BindingResult result, RedirectAttributes attr, Model model)
	{
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<ObjectError> error = result.getAllErrors();
			
			
			for(ObjectError err: error)
			{
				System.out.println(err.toString());
			}
			
		  attr.addFlashAttribute("org.springframework.validation.BindingResult.email", result);
		  attr.addFlashAttribute("email", emailBean);
		   
		   return "redirect:forgotPassword.html";
			
		}
		
		if(userService.blEmailExists(emailBean.getEmail()))
		{
			System.out.println("email exists");
			
			UmUserDetails user = userService.blGetUserByEmail(emailBean.getEmail());
			
			model.addAttribute("username", user.getUserName());
			
			return "resetPassword";
		}
		
		else
		{
			map.addAttribute("val", false);
			return "forgotPassword";
		}
	}
	
	@RequestMapping(value = "/passwordReset",  method = RequestMethod.POST)
	public String passwordReset(Model map,@ModelAttribute("reset") ResetBean resetBean) throws IOException
	{
		UmUserDetails user = userService.blGetUser(resetBean.getUserName());
		String password = userService.generateHashedPassword(resetBean.getPassword());
		user.setPassword(password);
		boolean val = userService.blAddUser(user);
		
		if(val)
		{
			
			map.addAttribute("val", true);
			return "redirect:login.html";
		}
		else
		{
			
			map.addAttribute("val", false);
			return "redirect:login.html";
		}
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword() 
	{
		return new ModelAndView("changePassword");
	}
	
	@RequestMapping(value = "/confirmPassword", method = RequestMethod.POST)
	public String confirmPassword(Model map, @ModelAttribute("change") @Valid ChangePasswordBean changeBean, BindingResult result, RedirectAttributes attr) throws IOException 
	{	
		
		if(result.hasErrors())
		{
			System.out.println(result.getErrorCount());
			List<ObjectError> error = result.getAllErrors();
			
			
			for(ObjectError err: error)
			{
				System.out.println(err.toString());
			}
			
		  attr.addFlashAttribute("org.springframework.validation.BindingResult.change", result);
		  attr.addFlashAttribute("change", changeBean);
		   
		   return "redirect:changePassword.html";
			
		}
		String username = changeBean.getUserName();
		String oldPassword = changeBean.getOldPassword();
		String newPassword = changeBean.getNewPassword();
		
		//HashMap<String, Object> model = new HashMap<String, Object>();
			
		
		if(userService.blAuthenticateUser(username, oldPassword))
		{
			UmUserDetails user = userService.blGetUser(username);
			
			String password = userService.generateHashedPassword(newPassword);
			user.setPassword(password);
			
			if(userService.blAddUser(user))
				map.addAttribute("success", true);
		
		}
		else
		{
			System.out.println("not authenticated");
			map.addAttribute("success", false);
		}
		return "changePassword";
	}
	/**
	 ***********************************************************************
	 */
	
	
	
	/**
	 *********************Bean creation functions*********************
	 */
	@ModelAttribute("user")
	public UserBean createUserModel() 
	{
	    return new UserBean();
	}
	
	@ModelAttribute("register")
	public RegisterBean createRegisterModel() 
	{
	    return new RegisterBean();
	}
	
	@ModelAttribute("faculty")
	public FacultyBean createFacultyModel() 
	{
	    return new FacultyBean();
	}
	
	@ModelAttribute("reset")
	public ResetBean createResetModel() 
	{
	    return new ResetBean();
	}
	
	@ModelAttribute("change")
	public ChangePasswordBean createChangeModel() 
	{
		return new ChangePasswordBean();
	}
	
	@ModelAttribute("email")
	public EmailBean crateEmailModel() 
	{
	    return new EmailBean();
	}
		
	@ModelAttribute("student")
	public StudentBean createStudentModel() 
	{
	    return new StudentBean();
	}
	/**
	 ******************************************************************
	 */
	
	
	
}
