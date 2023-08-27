package com.h.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="patient")
public class PatientLogin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pId;
	private String firstName;
	private String lastName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String dob;
	private String gender;
	private String email;
	private Long phoneNumber;
	private String password;
}
