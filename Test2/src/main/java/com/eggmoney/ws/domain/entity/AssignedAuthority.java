package com.eggmoney.ws.domain.entity;

public class AssignedAuthority extends Authority{
	
	private String grade;
	private String grade_name;
	
	public AssignedAuthority() {
	}
	
	public AssignedAuthority(String grade, String authority) {
		this.grade = grade;
		setAuthority(authority);
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
}
