package com.eggmoney.ws.domain.entity;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	public static enum ROLE_AUTH {
		MGR_USER ("MGR_USER"),
		MGR_AUTHORITY ("MGR_AUTHORITY"),
		MGR_GRADE ("MGR_GRADE"),
		VIEW_STAT ("VIEW_STAT");
		
		private String code;
		ROLE_AUTH(String code){
			this.code = code;
		}
		public String getCode() {
			return code;
		}
		public static ROLE_AUTH getAuth(String code){
			for(ROLE_AUTH auth : ROLE_AUTH.values()){
				if(StringUtils.equals(auth.getCode(), code)){
					return auth;
				}
			}
			return null;
		}
	}
	
	private String authority;
	private String name;
	private String description;
	private Date create_date;
	private String creator;
	private Date update_date;
	private String updator;
	
	public Authority() {
	}

	public Authority(String authority){
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
