/**
 * 
 */
package com.srmri.plato.rbac.form;

import javax.validation.constraints.NotNull;

/**
 * @author srmri
 *
 */
public class RolePermissionsForm {
	@NotNull(message = "Select a role!")
	private Integer roleId;
	@NotNull
	private String[] selectedPermissionsList;

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the selectedPermissionsList
	 */
	public String[] getSelectedPermissionsList() {
		return selectedPermissionsList;
	}

	/**
	 * @param selectedPermissionsList the selectedPermissionsList to set
	 */
	public void setSelectedPermissionsList(String[] selectedPermissionsList) {
		this.selectedPermissionsList = selectedPermissionsList;
	}	
	
	
}
