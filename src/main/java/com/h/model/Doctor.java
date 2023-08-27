package com.h.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctor")

public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dId;
	private String firstName;
	private String lastName;
	private String qualification;
	private String specialties;
	private String email;
	private Long phoneNumber;
	private String password;

}
