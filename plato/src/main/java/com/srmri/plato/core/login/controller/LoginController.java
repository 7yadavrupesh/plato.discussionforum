package main.java.com.srmri.plato.core.login.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srmri.plato.core.rbac.entity.Role;
import com.srmri.plato.core.rbac.entity.RoleAssignment;
import com.srmri.plato.core.rbac.entity.RoleLevel;
import com.srmri.plato.core.rbac.service.RoleAssignmentService;
import com.srmri.plato.core.rbac.service.RoleLevelService;
import com.srmri.plato.core.rbac.service.RoleService;

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

public class LoginController 
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
	private RoleLevelService roleLevelService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleAssignmentService roleAssignmentService;
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() 
	{		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView authenticate(Model model, @ModelAttribute("user") UserBean userBean, BindingResult result)
	{
		
		boolean val = userService.blAuthenticateUser(userBean.getUserName(), userBean.getPassword());;
		
		if(val)
		{
			System.out.println("authenticated");
		   UmUserDetails user = userService.blGetUser(userBean.getUserName());
		   long userId = user.getUserId();
		   userBean.setUserId(userId);
		   
		   List<RoleAssignment> rolesAss = roleAssignmentService.rbac_bl_getUserRoleIds(userId);
		   
		   List<Role> roles = new ArrayList<Role>();
		   
		   for(RoleAssignment rlAss: rolesAss)
		   {
			   Role role = roleService.rbac_bl_getRole(rlAss.getRoleId());
			   
			   roles.add(role);
			   
		   }
		   
		   for(Role role: roles)
		   {
			   System.out.println("role details "+role.getRoleName()+" "+role.getRoleId());
		   }
		   
		   HashMap<String, Object> map = new HashMap<String,Object>();
		   map.put("roleList", roles);
		   return new ModelAndView("authenticate", map);
		   
		 		   
		}
		else
		{
			//HashMap<String, Object> model = new HashMap<String, Object>();
			model.addAttribute("val", val);	
		
			return new ModelAndView("login");
		}
    
	}
	
	@RequestMapping(value = "/authenticateComplete", method = RequestMethod.POST)
    public String authenticateComplete(Model model,@ModelAttribute("user") UserBean userBean, BindingResult result)
	{
		
		String role = userBean.getRole();
		
		String[] tokens = role.split(",", -1);
			
		
		userBean.setRoleId(Integer.parseInt(tokens[0]));
		
		
		return "redirect:listTopic.html";
		   
		
    
	}
	
	@RequestMapping(value = "/logout")
    public String logout(@ModelAttribute("user") UserBean userBean)
	{
		
		userBean = null;
		
		
		return "login";
		
    
	}
				
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("user") UserBean userBean) 
	{
		//System.out.println(userBean.getUserId());
		return new ModelAndView("changePassword");
	}
	
	@RequestMapping(value = "/confirmPassword", method = RequestMethod.POST)
	public ModelAndView confirmPassword(Model map, @ModelAttribute("user") UserBean userBean, BindingResult result) throws IOException 
	{	
		String username = userBean.getUserName();
		String oldPassword = userBean.getOldPassword();
		String newPassword = userBean.getNewPassword();
		
		HashMap<String, Object> model = new HashMap<String, Object>();
			
		
		if(userService.blAuthenticateUser(username, oldPassword))
		{
			UmUserDetails user = userService.blGetUser(username);
			
			String password = userService.generateHashedPassword(newPassword);
			user.setPassword(password);
			
			if(userService.blAddUser(user))
				model.put("success", true);
		
		}
		else
		{
			System.out.println("not authenticated");
			model.put("success", false);
		}
		return new ModelAndView("changePassword", model);
	}
		
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() throws IOException 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		List<Role> roleList = roleService.rbac_bl_listRoles();
		
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
			
			Role role = roleService.rbac_bl_getRole(regBean.getRoleId());
			
			RoleLevel roleLevel = roleLevelService.rbac_bl_getRoleLevel(role.getRoleLevelId());
			
			String rlName = roleLevel.getRoleLevelName();
					//roleLevelService.rbac_bl_getRoleLevel(regBean.getRoleLevelId()).getRoleLevelName();
			
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
		
	@RequestMapping(value = "/addadmin", method = RequestMethod.GET)
    public ModelAndView addAdmin(@ModelAttribute("register") @Valid RegisterBean regBean,BindingResult result) throws IOException, ParseException
    {
		boolean success = false;
		
		MultipartFile file = null;	
		
		byte[] bytes = null;
		
		long userId = 0;
		File serverFile = null;
		
		String key = userService.randomPasswordGenerator(20);
		String password = userService.generateHashedPassword(key);
		
		try	
		{  
			//System.out.println(System.getProperty("user.dir"));
			//System.out.println("image file "+regBean.getImage());
			
			//System.out.println("image name "+regBean.getImageName());
			
			file = regBean.getImage();
			regBean.setImageName(file.getOriginalFilename());
			bytes = file.getBytes();
								
			String rootPath = System.getProperty("user.dir");
			
			//System.out.println("rootpath "+rootPath);
			
			File dir = new File(rootPath+File.separator+"tmpFiles");
			
			//System.out.println("dir "+dir);	
			
			if (!dir.exists())
                  dir.mkdirs();
				
			serverFile = new File(dir.getAbsolutePath()+File.separator+file.getOriginalFilename());
			
			//System.out.println("server file "+serverFile);
			
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
			
			
			RoleAssignment roleAssignment = new RoleAssignment();
			
			roleAssignment.setRoleId(regBean.getRoleId());
			roleAssignment.setUserId(user.getUserId());
			
			roleAssignmentService.rbac_bl_addRoleAssignment(roleAssignment);
			
			model1.put("val", "successful");
			model1.put("username", user.getUserName());
			model1.put("key", key);
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
				
				
				
				RoleAssignment roleAssignment = new RoleAssignment();
				roleAssignment.setRoleId(regBean.getRoleId());
				roleAssignment.setUserId(userId);
				roleAssignmentService.rbac_bl_addRoleAssignment(roleAssignment);
				
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
				
				
				RoleAssignment roleAssignment = new RoleAssignment();
				roleAssignment.setRoleId(regBean.getRoleId());
				roleAssignment.setUserId(userId);
				
				roleAssignmentService.rbac_bl_addRoleAssignment(roleAssignment);
				
				newModel.put("val", "successful");
				newModel.put("key", key);
			}
			else
				newModel.put("val", "failed");
			return new ModelAndView("useradded", newModel);
						
		}
		
	}
	
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
	
	@ModelAttribute("student")
	public StudentBean createStudentModel() 
	{
	    return new StudentBean();
	}
	
}
