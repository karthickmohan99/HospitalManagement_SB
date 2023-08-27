package com.h.model;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int apId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName="pId", nullable=false)
	private PatientLogin patients;
	
	@ManyToOne
	@JoinColumn(name = "session_id", referencedColumnName="sId", nullable=false)
	private ScheduleSession session;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String sessionDate;
	private Long appno;

}
