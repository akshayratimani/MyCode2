package com.training.poc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CartId.class)
@Table(name = "cart")
public class Cart {

	@Id
	private int pid;
	@Id
	private String phoneno;
	private int quantity;

	public Cart() {
	}

	public Cart(int pid, String phoneno, int quantity) {
		super();
		this.pid = pid;
		this.phoneno = phoneno;
		this.quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [pid=" + pid + ", phoneno=" + phoneno + ", quantity=" + quantity + "]";
	}

}
