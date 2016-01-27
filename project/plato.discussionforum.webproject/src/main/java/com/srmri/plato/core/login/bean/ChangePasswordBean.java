package main.java.com.srmri.plato.core.login.bean;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class ChangePasswordBean implements Serializable 
{
	
	private static final long serialVersionUID = 2529261045652200172L;

	@Size(min=1, max=255, message="Cannot be null")
	private String userName;
	
	@Size(min=8, max=255, message="Password should be atleast 8 characters long")
	private String newPassword;
	
	@Size(min=8, max=255, message="Password should be atleast 8 characters long")
	private String oldPassword;

	/**
	 * @return the userName
	 */
	public String getUserName() 
	{
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param password the password to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	

}
