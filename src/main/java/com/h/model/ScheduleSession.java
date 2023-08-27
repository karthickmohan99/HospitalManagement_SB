package com.h.model;

import java.sql.Time;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sessions")
public class ScheduleSession {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sId;
	private String sessionTitle;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="dId")
	private String doctorName;
	
	private Long appointmentNumber;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String sessionDate;
	private Time scheduleTime;
	private float consultFee;
	
}
