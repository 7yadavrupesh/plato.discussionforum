/**
 * 
 */
package com.srmri.plato.rbac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.srmri.plato.core.rbac.entity.Permissions;
import com.srmri.plato.core.rbac.entity.Role;
import com.srmri.plato.core.rbac.entity.RoleLevel;
import com.srmri.plato.core.rbac.entity.RolePermissionsMap;
import com.srmri.plato.core.rbac.service.ModulesService;
import com.srmri.plato.core.rbac.service.PermissionsService;
import com.srmri.plato.core.rbac.service.RoleLevelService;
import com.srmri.plato.core.rbac.service.RolePermissionsMapService;
import com.srmri.plato.core.rbac.service.RoleService;
import com.srmri.plato.rbac.form.RolePermissionsForm;
import com.srmri.plato.rbac.validator.RolePermissionsFormValidator;


@Controller
public class RbacController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ModulesService modulesService;
	
	@Autowired
	private RoleLevelService roleLevelService;
	
	@Autowired
	private PermissionsService permissionsService;
	
	@Autowired
	private RolePermissionsMapService rolePermissionsMapService;
	
	@Autowired
	private RolePermissionsFormValidator rolePermissionsFormValidator; 
	
	
	
	@RequestMapping("/role")
    public ModelAndView showContacts(@ModelAttribute("command") Role role, BindingResult result) {         
		Map<String, Object> model = new HashMap<String, Object>();
		List<Role> modulesList = roleService.rbac_bl_listRoles();
		model.put("roleLevelList", roleLevelService.rbac_bl_listRoleLevels());
		model.put("roles",  modulesList);	
		model.put("rbacHeadingValue", "Add New Role");
		model.put("rbacDisplayAddRoleButton", "0");
		return new ModelAndView("role", model);
    }
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role, BindingResult result) {	         
        //System.out.println("Role Name:" + role.getRoleName() + 
         //           "Role Description:" + role.getDescription()+ "Role Level Id:"+role.getRoleLevelId());
        roleService.rbac_bl_addRole(role);
        return "redirect:role.html";
    }
	
	@RequestMapping(value = "/editRole", method = RequestMethod.GET)
	public ModelAndView editRole(@ModelAttribute("command")  Role role,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("roleLevelList", roleLevelService.rbac_bl_listRoleLevels());
		model.put("role", roleService.rbac_bl_getRole(role.getRoleId()));
		model.put("roles",  roleService.rbac_bl_listRoles());
		model.put("rbacHeadingValue", "Add New Role");
		model.put("rbacDisplayAddRoleButton", "1");
		return new ModelAndView("role", model);
	}
	
	@RequestMapping(value = "/deleteRole", method = RequestMethod.GET)
	public ModelAndView deleteRole(@ModelAttribute("command")   Role role,
			BindingResult result) {
		roleService.rbac_bl_deleteRole(role);
		role.setRoleId(null);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("roleLevelList", roleLevelService.rbac_bl_listRoleLevels());
		model.put("role", null);
		model.put("roles",  roleService.rbac_bl_listRoles());
		model.put("rbacHeadingValue", "Add New Role");
		model.put("rbacDisplayAddRoleButton", "0");
		return new ModelAndView("role", model);
	}
	
	 @RequestMapping("/hello")
	 public ModelAndView hello() {	 
	        String message = "Hello World, Spring 3.0!";
	        return new ModelAndView("hello", "message", message);
	 }
	 
	 @RequestMapping("/login")
	 public ModelAndView loginExample() {	 
	        //String message = "Hello World, Spring 3.0!";
	        return new ModelAndView("login");
	 }
	 
	
	
	@RequestMapping("/roleLevel")
    public ModelAndView listRoleLevels(@ModelAttribute("command") RoleLevel roleLevel, BindingResult result) {         
		Map<String, Object> model = new HashMap<String, Object>();
		List<RoleLevel> roleLevelsList = roleLevelService.rbac_bl_listRoleLevels();		
		model.put("roleLevels",  roleLevelsList);	
		model.put("rbacHeadingValue", "Add New Role Level");
		model.put("rbacDisplayAddRoleLevelButton", "0");
		return new ModelAndView("roleLevel", model);
    }
	
	@RequestMapping(value = "/addRoleLevel", method = RequestMethod.POST)
    public String addRoleLevel(@ModelAttribute("roleLevels") RoleLevel roleLevels, BindingResult result) {	
		roleLevelService.rbac_bl_addRoleLevel(roleLevels);
		return "redirect:roleLevel.html";		
    }
	
	@RequestMapping(value = "/editRoleLevel", method = RequestMethod.GET)
	public ModelAndView editRoleLevel(@ModelAttribute("command")  RoleLevel roleLevels,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("roleLevel", roleLevelService.rbac_bl_getRoleLevel(roleLevels.getRoleLevelId()));
		model.put("roleLevels",  roleLevelService.rbac_bl_listRoleLevels());
		model.put("rbacHeadingValue", "Edit Role Level");
		model.put("rbacDisplayAddRoleLevelButton", "1");
		return new ModelAndView("roleLevel", model);
	}
	
	@RequestMapping(value = "/deleteRoleLevel", method = RequestMethod.GET)
	public ModelAndView deleteRoleLevel(@ModelAttribute("command")  RoleLevel roleLevels,
			BindingResult result) {
		roleLevelService.rbac_bl_deleteRoleLevel(roleLevels);
		Map<String, Object> model = new HashMap<String, Object>();
		roleLevels.setRoleLevelId(null);
		model.put("roleLevel", null);
		model.put("roleLevels",  roleLevelService.rbac_bl_listRoleLevels());
		model.put("rbacHeadingValue", "Add New Role Level");
		model.put("rbacDisplayAddRoleLevelButton", "0");
		return new ModelAndView("roleLevel", model);
	}
	
	@RequestMapping("/permissions")
    public ModelAndView listPermissions(@ModelAttribute("command") Permissions permissions, BindingResult result) {         
		Map<String, Object> model = new HashMap<String, Object>();		
		Map<String,List<Permissions>> modulesPermissions= permissionsService.rbac_bl_getAllModulesPermissions();
		model.put("modulesList", modulesService.rbac_bl_listModules());
		model.put("modulesPermissions",  modulesPermissions);	
		model.put("rbacHeadingValue", "Add New Permission");
		model.put("rbacDisplayAddPermissionButton", "0");
		return new ModelAndView("permissions", model);
    }
	
	@RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    public String addPermission(@ModelAttribute("permissions") Permissions permissions, BindingResult result) {	
		permissionsService.rbac_bl_addPermission(permissions);
		return "redirect:permissions.html";		
    }
	
	@RequestMapping("/rolePermissions")
    public ModelAndView listRoleLevels(@ModelAttribute("command") RolePermissionsForm rolePermissionsForm, BindingResult result) {         
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String,List<Permissions>> modulesPermissions= permissionsService.rbac_bl_getAllModulesPermissions();
		model.put("roles",  roleService.rbac_bl_listRoles());		
		model.put("modulesPermissions",  modulesPermissions);
		model.put("rbacHeadingValue", "Add Role Permissions");		
		return new ModelAndView("rolePermissions", model);
    }
	
	@RequestMapping(value = "/addRolePermissions", method = RequestMethod.POST)
    public String addRolePermissions(@Valid @ModelAttribute("rolePermissions") RolePermissionsForm rolePermissionsForm, BindingResult result) {	
		//System.out.println(rolePermissionsForm.getSelectedPermissionsList().length);		
		rolePermissionsFormValidator.validate(rolePermissionsForm, result);
		if (result.hasErrors()) {
            return "redirect:rolePermissions.html";
        } 
		List<RolePermissionsMap> rolePermissionsDeleteList = rolePermissionsMapService.rbac_bl_getRolePermissions(rolePermissionsForm.getRoleId());
		for (int i = 0; i < rolePermissionsDeleteList.size(); i++) {
			rolePermissionsMapService.rbac_bl_deleteRolePermissionMap(rolePermissionsDeleteList.get(i));
		}
		
		String[] permissionsList = rolePermissionsForm.getSelectedPermissionsList();		
		for (int i = 0; i < permissionsList.length; i++) {
			RolePermissionsMap rolePermissionMap = new RolePermissionsMap();			
			rolePermissionMap.setRoleId(rolePermissionsForm.getRoleId());
			rolePermissionMap.setPermissionId(Long.parseLong(permissionsList[i]));
			rolePermissionsMapService.rbac_bl_addRolePermissionMap(rolePermissionMap);
		}
		return "redirect:rolePermissions.html";		
    }
	
	@RequestMapping("/changeRole")
    public ModelAndView changeRole(@RequestParam("id") String roleId, @ModelAttribute("command") RolePermissionsForm rolePermissionsForm, BindingResult result) {         
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String,List<Permissions>> modulesPermissions= permissionsService.rbac_bl_getAllModulesPermissions();
		model.put("roles",  roleService.rbac_bl_listRoles());
		model.put("selectedRole", Integer.parseInt(roleId));
		model.put("rolePermissions", rolePermissionsMapService.rbac_bl_getRolePermissions(Integer.parseInt(roleId)));
		model.put("modulesPermissions",  modulesPermissions);
		model.put("rbacHeadingValue", "Add Role Permissions");		
		return new ModelAndView("rolePermissions", model);
    }	

}
