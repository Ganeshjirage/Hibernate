package com.oneToMany.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "policyid")
	private String policyId;

	@Column(name = "policytype")
	private String policyType;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyId=" + policyId + ", policyType=" + policyType + ", status=" + status
				+ ", user=" + user + "]";
	}

	public Policy(String policyId, String policyType, String status, User user) {
		super();

		this.policyId = policyId;
		this.policyType = policyType;
		this.status = status;
		this.user = user;
	}

}
