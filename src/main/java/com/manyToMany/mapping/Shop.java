package com.manyToMany.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@ManyToMany(mappedBy = "shopList")
	//@JoinColumn(name = "cust_id", nullable = false)
	private List<Customer2> coustomerList = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Customer2> getCoustomerList() {
		return coustomerList;
	}

	public void setCoustomerList(List<Customer2> coustomerList) {
		this.coustomerList = coustomerList;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", coustomerList="
				+ coustomerList + "]";
	}

}
