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
 
package com.srmri.plato.core.discussionforum.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.srmri.plato.core.discussionforum.entity.DfTopic;

@Component
public class TopicFormValidator implements Validator{
//	@Autowired
//	@Qualifier("emailValidator")
//	EmailValidator emailValidator;
//	
//	@Autowired
//	UserService userService;
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override	
	public boolean supports(Class<?> clazz) {		
		return DfTopic.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "topicTitle","error.topicTitle", "Enter a Topic Name");
	}
}
