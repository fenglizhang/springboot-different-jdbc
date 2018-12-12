package com.zlf.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="staff")
public class StaffBo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
}
