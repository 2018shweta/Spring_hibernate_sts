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
	private Float balance;
	private String currency;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "userId")
	UserBean users;
	
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public UserBean getUsers() {
		return users;
	}
	public void setUsers(UserBean users) {
		this.users = users;
	}
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
