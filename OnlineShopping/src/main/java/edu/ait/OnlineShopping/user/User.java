package edu.ait.OnlineShopping.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name ="users")
public class User {
	
	@Id
	@SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
	private Long id;
	private String name;
	private String address;
	private String email;
	
	public User(Long id,String name,
			    String address,
			    String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	public User(String name,
		
			String address,
			 String email) {
		this.name =name;
		this.address =address;
		this.email =email;
		
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(int i) {
		this.id = (long) i;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
    public String getAddress() {
    	return address;
    }
	
	
	public void setEmail1(String email) {
		this.email = email;
	}
    public String getEmail() {
    	return email;
    }
    
    public String toString() {
    	return "User{" +"id"+id+",name='"+name+'\''+","
    			+ "address="+address+'\''+","
    			+"email='"+email+'\''+'}';
    }
	
	
}
