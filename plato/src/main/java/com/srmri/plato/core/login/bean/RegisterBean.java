package main.java.com.srmri.plato.core.login.bean;

import java.text.ParseException;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;
import java.io.IOException;


public class RegisterBean 
{   
	
	@Size(min=1, max=255, message="Cannot be null")
	private String userName;
	
	
	@Size(min=1, max=255, message="Cannot be null")
	private String firstName;
        
    @Size(min=1, max=255, message="Cannot be null")
	private String lastName;
        
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
    		   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Not a valid email")
	private String email;
        
    @Size(min=1, max=255, message="Cannot be null")
    private String dateOfBirth;
    
	private String imageName;
		
	private String gender;
		
	@Size(min=1, max=255, message="Cannot be null")
	private String role;
	
	private Integer roleId;
	
	private String roleName;
		
	
	
	private MultipartFile image;
		
	private String imageUploadPath;
	
	
	/**
	 * Default constructor
	 */
	public RegisterBean()
	{}
	
	
	/**
	 * @return the firstName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
		
	/**
	 * Get roleLevel
	 * @return String roleLevel
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Set roleLevel
	 * @param String roleLevel
	 */
	public void setRole(String roleLevel) {
		this.role = roleLevel;
	}
	
	/**
	 * @return the image
	 */
	public MultipartFile getImage() {
		return image;
	}
	
	/**
	 * @param image the image to set
	 */
	public void setImage(MultipartFile image) {
		if(image==null)
			return;
		else
			this.image = image;
	}
	
	
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	
	
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	/**
	 * @return the imageUploadPath
	 */
	public String getImageUploadPath() {
		return imageUploadPath;
	}
	/**
	 * @param imageUploadPath the imageUploadPath to set
	 */
	public void setImageUploadPath(String imageUploadPath) {
		this.imageUploadPath = imageUploadPath;
	}
	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}
	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the roleLevelId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleLevelId the roleLevelId to set
	 */
	public void setRoleId(Integer roleLevelId) {
		this.roleId = roleLevelId;
	}
	
	
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Creates a UmUserDetails model from this bean data
	 * @param password - hashed password to be set for the user
	 * @return UmUserDetails object
	 * @throws IOException - for image file
	 * @throws ParseException - for parsing date from String
	 */
	public UmUserDetails prepareModel(String password) throws IOException, ParseException
	{
			
		UmUserDetails user = new UmUserDetails();
	    user.setUserName(this.getUserName());
	    user.setGender(this.getGender());
	    user.setEmailId(this.getEmail());
	    user.setPassword(password);
	    user.setImage(this.getImageUploadPath());
	       	
	 	return user;
	
	}
	
}
