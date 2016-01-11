/**
 * 
 */
package com.srmri.plato.rbac.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.srmri.plato.rbac.form.RolePermissionsForm;

/**
 * @author srmri
 *
 */
@Component
public class RolePermissionsFormValidator implements Validator{

	/**
	 * Method definition
	 */
	@Override
	public boolean supports(Class<?> clazz) {		
		return RolePermissionsForm.class.isAssignableFrom(clazz);
	}

	/**
	 * Method definition
	 */
	@Override
	public void validate(Object target, Errors errors) {
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleId","error.roleId", "Select a role");
		RolePermissionsForm rolePermissionsForm = (RolePermissionsForm) target;		
        if(rolePermissionsForm.getRoleId() == null){
        	System.out.println(rolePermissionsForm.getRoleId());
        	errors.rejectValue("roleId", "not_zero", "Can't be free!");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "selectedPermissionsList","error.selectedPermissionsList", "Select permissions for the role");
	}

}
