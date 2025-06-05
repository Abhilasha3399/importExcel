package com.excel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer Id;
 private String name;
 private String course;
 private double amount;
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Product(Integer id, String name, String course, double amount) {
	super();
	Id = id;
	this.name = name;
	this.course = course;
	this.amount = amount;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
}
