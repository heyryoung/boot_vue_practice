package com.test.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name="PERSON")
@Component
public class Person {
		@Id
		@GeneratedValue
		@Column(name="ID" , nullable=false) 
		private Long id;
		@Column(name="CID" , length = 64,  nullable=false) 
		private String cid;
		@Column(name="PWD" , length = 64,  nullable=false) 
		private String pwd;
		@Column(name="NAME" , length = 64,  nullable=false) 
		private String name;
		@Temporal(TemporalType.DATE)
		@Column(name="BIRTHDAY" , nullable=false) 
		private Date birthday;  //import java.util.Date;
		@Column(name="GENDER", nullable=false)
		private String gender; 
		@Column(name="HAK", nullable=false)
		private Integer hak; 
		@Column(name="BAN", nullable=false)
		private Integer ban; 
		@Column(name="SCORE", nullable=false)
		private Integer score; 
}
