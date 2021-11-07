
package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserClass {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;
    
    private String username;
    
    private String password;
    
    // VV Stretch Goal Fields
    private String email;
    private String phone;
    private String securityQuestion;
    
    
    
    
    //constructors 
	public UserClass(int userId, String username, String password, String email, String phone,
			String securityQuestion) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.securityQuestion = securityQuestion;
	}
	public UserClass(String username, String password, String email, String phone, String securityQuestion) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.securityQuestion = securityQuestion;
	}
	public UserClass() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserClass other = (UserClass) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (securityQuestion == null) {
			if (other.securityQuestion != null)
				return false;
		} else if (!securityQuestion.equals(other.securityQuestion))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserClass [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", securityQuestion=" + securityQuestion + "]";
	}
    
     
    
}