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
@Table(name="shoe")
public class Shoe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long sid;
	@Column(name="category")
	private String category;
	@Column(name="size")
	private String size;
	
	@OneToMany(mappedBy="shoe",fetch = FetchType.LAZY)
	private Set<Order> order=new HashSet<>();
	
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}


}
