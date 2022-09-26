package com.project.foodOrdering.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String BranchName;
	private String BranchAddress;
	private long BranchPhone;
	private String BranchEmail;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	public Branch() {
		
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	public String getBranchAddress() {
		return BranchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		BranchAddress = branchAddress;
	}

	public long getBranchPhone() {
		return BranchPhone;
	}

	public void setBranchPhone(long branchPhone) {
		BranchPhone = branchPhone;
	}

	public String getBranchEmail() {
		return BranchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		BranchEmail = branchEmail;
	}
}
