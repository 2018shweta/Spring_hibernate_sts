package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="accounts")
public class AccountBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private String accountType;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "userId")
	UserBean users;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public UserBean getUser() {
		return users;
	}
	public void setUser(UserBean user) {
		this.users = user;
	}
	
	
	
}
