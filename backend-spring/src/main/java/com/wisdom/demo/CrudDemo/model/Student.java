package com.wisdom.demo.CrudDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="tbl_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
	@Column(name ="first_name", length = 60)
	private String firstName;

	@NotBlank(message = "El apellido es obligatorio")
	@Column(name ="last_name", length = 60)
	private String lastName;

	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "Debe ser un formato de correo válido")
	@Column(name ="email", length = 60, unique = true)
	private String email;

	@NotNull(message = "El número móvil es obligatorio")
	@Column(name ="mobile_number", length = 60)
	private Integer mobileNumber;

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
