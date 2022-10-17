package com.example.mypkg.entity;



import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id

	// @GeneratedValue(strategy=GenerationType.SEQUENCE)

	private int id;
	@NotEmpty(message = "username must not be null")
	private String firstname;
	private String lastname;
	private Date dob;
	@Email(message = "Email is invalid")
	private String email;
	@NotEmpty
	@Size(min = 8, max = 10, message = "password should be min of 8 and max of 10")
	private String password;

	public Customer() {
	}

	public Customer(int id, String firstname, String lastname, Date dob, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
