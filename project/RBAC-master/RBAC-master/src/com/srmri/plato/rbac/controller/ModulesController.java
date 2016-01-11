/**********************************************************************************
* File-name - ModulesController.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
*
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
*
***********************************************************************************
*
* Description: The controller to handle module management 
*
**********************************************************************************/
 
package com.srmri.plato.rbac.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srmri.plato.core.rbac.entity.Modules;
import com.srmri.plato.core.rbac.service.ModulesService;
import com.srmri.plato.rbac.validator.ModulesFormValidator;

@Controller
public class ModulesController {
	
	@Autowired
	private ModulesService modulesService;
	
	@Autowired
	private ModulesFormValidator modulesFormValidator;	
	
	/*
	 * The function to bind the validator for module management
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(modulesFormValidator);
	}
	
	/*
	 * Displays an empty form with the list of existing modules
	 */
	@RequestMapping(value = "/modules")
    public String RbacUiListModules(Model model) {				
		Modules modules = new Modules();		
		RbacUiPopulateModulestModel(model);
		model.addAttribute("modulesForm", modules);
		return "module";
    }
	
	/*
	 * Used to add a new module or update an existing module
	 */
	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
    public String RbacUiAddModule(@ModelAttribute("modulesForm") @Validated Modules modules, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {	
		System.out.println(modules.getDescription());
		if(result.hasErrors()){
			RbacUiPopulateModulestModel(model);
			return "module";				
		}
		else{						
			redirectAttributes.addFlashAttribute("css", "success");			
			if(modules.isNew()){
				redirectAttributes.addFlashAttribute("alertMessage", "New User is added!");
			}
			else{
				redirectAttributes.addFlashAttribute("alertMessage", "User details successfully updated!");
			}
			modulesService.rbac_bl_addModule(modules);	
			return "redirect:modules.html";	
		}				
			
    }
	
	/*
	 * Used to retrieve and display the value of a particular module
	 */
	@RequestMapping(value = "/editModule", method = RequestMethod.GET)
	public String RbacUiEditModule(@ModelAttribute("command")  Modules modules,
			BindingResult result,Model model) {
		Modules modulesNew = new Modules();
		model.addAttribute("modulesForm", modulesNew);
		model.addAttribute("module", modulesService.rbac_bl_getModule(modules.getModuleId()));		
		RbacUiPopulateModulestModel(model);
		model.addAttribute("rbacHeadingValue", "Edit Module");
		model.addAttribute("rbacDisplayAddModuleButton", "1");
		return "module";
	}
	
	/*
	 * Used to delete the details of an existing module
	 */
	@RequestMapping(value = "/deleteModule", method = RequestMethod.GET)
	public String RbacUiDeleteModule(@ModelAttribute("command")  Modules modules,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		modulesService.rbac_bl_deleteModule(modules);		
		redirectAttributes.addFlashAttribute("css", "success");		
		redirectAttributes.addFlashAttribute("alertMessage", "User Details successfully deleted!");
		return "redirect:modules.html";	
	}
	
	public void RbacUiPopulateModulestModel(Model model) {	
		List<Modules> modulesList = modulesService.rbac_bl_listModules();			
		model.addAttribute("modules",  modulesList);
		model.addAttribute("rbacHeadingValue", "Add New Module");
		model.addAttribute("rbacDisplayAddModuleButton", "0");
	}

}
