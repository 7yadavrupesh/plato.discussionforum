/**********************************************************************************
* File-name - <file name>
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
* Description: <Add description about the file>
*
**********************************************************************************/
 
package com.srmri.plato.rbac.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.srmri.plato.core.rbac.entity.Modules;

@Component
public class ModulesFormValidator implements Validator{

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override	
	public boolean supports(Class<?> clazz) {		
		return Modules.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "moduleName","error.moduleName", "Enter a module name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","error.description", "Enter module description");
	}
}
