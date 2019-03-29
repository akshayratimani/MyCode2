package com.training.poc.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class CartId implements Serializable {

	private int pid;
	private String phoneno;
	
	public CartId() {
	
	}

	public CartId(int pid, String phoneno) {
		super();
		this.pid = pid;
		this.phoneno = phoneno;
	}

	public int getPid() {
		return pid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneno == null) ? 0 : phoneno.hashCode());
		result = prime * result + pid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartId other = (CartId) obj;
		if (phoneno == null) {
			if (other.phoneno != null)
				return false;
		} else if (!phoneno.equals(other.phoneno))
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}
	
	
}
