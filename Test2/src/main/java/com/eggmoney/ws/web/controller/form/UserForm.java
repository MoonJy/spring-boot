package com.eggmoney.ws.web.controller.form;

import com.eggmoney.ws.domain.entity.User;

public class UserForm extends SearchForm {
	private String user_id;
	private User user;

	private String id;

	public UserForm() {
		this(new User());
	}

	public UserForm(User user) {
		this.user = user;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
