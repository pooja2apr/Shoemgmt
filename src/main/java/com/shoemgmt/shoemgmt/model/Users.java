package com.shoemgmt.shoemgmt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long uid;
@Column(name = "email")
private String email;

@Column(name = "first_name")
private String firstName;

@Column(name = "last_name")
private String lastName;

@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
private Set<Order> Order=new HashSet<>();

public Set<Order> getOrder() {
	return Order;
}

public void setOrder(Set<Order> order) {
	Order = order;
}

public long getUid() {
	return uid;
}

public void setUid(long uid) {
	this.uid = uid;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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

}
