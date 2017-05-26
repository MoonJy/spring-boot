package com.eggmoney.ws.domain.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eggmoney.ws.define.AccountType;
import com.eggmoney.ws.define.MemberType;
import com.eggmoney.ws.utils.Messages;


/**
 * Created by comec on 2017-05-06.
 */

public class User implements UserDetails {

    /**
     * serialVesionUID for Session Clustering
     */
    private static final long serialVersionUID = 7000566578275540831L;


    public enum STATUS {
        DISABLE("0", Messages.getMessage("USER.STATUS.DISABLE")),
        ENABLE("1", Messages.getMessage("USER.STATUS.ENABLE")),
        DORMANT("2", Messages.getMessage("USER.STATUS.DORMANT")),
        BLOCK("8", Messages.getMessage("USER.STATUS.BLOCK")),
        WITHDRAWAL("9", Messages.getMessage("USER.STATUS.WITHDRAWAL")),
        ;

        private String code;
        private String name;

        STATUS(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static STATUS get(String code) {
            for (STATUS item : values()) {
                if (StringUtils.equals(code, item.getCode())) {
                    return item;
                }
            }
            return null;
        }
    }

    public enum USER_GRADE {
        USER("USER"),
        ADMIN("ADMIN")
        ;

        private String code;

        USER_GRADE(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static USER_GRADE get(String code) {
            for (USER_GRADE item : USER_GRADE.values()) {
                if (StringUtils.equals(code, item.getCode())) {
                    return item;
                }
            }
            return null;
        }
    }

    private Long member_no;
    private String member_id;
    private String password;
    private String name;
    private int member_type = MemberType.USER.getCode();
    private int account_type = AccountType.DS.getCode();
    private String status;
    private String phone_no;
    private String nickname;
    private String mobile_no;
    private String email;
    private String profile_url;
    private String profile_file;
    private String profile_path;
    private int mailing_yn = 0;
    private int sms_yn = 0;
    private String grade;
    private Date withdrawal_date;
    private Date create_date;
    private Date update_date;
    private String allowed_ip = "*";
    private String person_agree = "Y";
    private Date person_agree_date;
    private int attempt_login_count = 0;
    private Date last_logined;
    private String login_ip;
    private Date password_ch_date;
    private String creator;
    private String updator;

    private String plain_password;
    private String validate_password;
    private String original_password;

    private Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    
    public void addAuthority(GrantedAuthority auth) {
        authorities.add(auth);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return member_id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        int count = Integer.parseInt(Messages.getMessage("POLICY.ACCOUNT.LOCK.COUNT"));
        return attempt_login_count < count;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (password_ch_date == null) {
            return true;
        }
        Calendar cal = Calendar.getInstance();
        int period = Integer.parseInt(Messages.getMessage("POLICY.PASSWORD.CHANGE.PERIOD"));
        cal.add(Calendar.MONTH, -period);

        Calendar chDate = Calendar.getInstance();
        chDate.setTime(password_ch_date);
        return !cal.after(chDate);
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(getStatus(), STATUS.ENABLE.getCode());
    }

	public Long getMember_no() {
		return member_no;
	}

	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMember_type() {
		return member_type;
	}

	public void setMember_type(int member_type) {
		this.member_type = member_type;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}

	public String getProfile_file() {
		return profile_file;
	}

	public void setProfile_file(String profile_file) {
		this.profile_file = profile_file;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	public int getMailing_yn() {
		return mailing_yn;
	}

	public void setMailing_yn(int mailing_yn) {
		this.mailing_yn = mailing_yn;
	}

	public int getSms_yn() {
		return sms_yn;
	}

	public void setSms_yn(int sms_yn) {
		this.sms_yn = sms_yn;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getWithdrawal_date() {
		return withdrawal_date;
	}

	public void setWithdrawal_date(Date withdrawal_date) {
		this.withdrawal_date = withdrawal_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getAllowed_ip() {
		return allowed_ip;
	}

	public void setAllowed_ip(String allowed_ip) {
		this.allowed_ip = allowed_ip;
	}

	public String getPerson_agree() {
		return person_agree;
	}

	public void setPerson_agree(String person_agree) {
		this.person_agree = person_agree;
	}

	public Date getPerson_agree_date() {
		return person_agree_date;
	}

	public void setPerson_agree_date(Date person_agree_date) {
		this.person_agree_date = person_agree_date;
	}

	public int getAttempt_login_count() {
		return attempt_login_count;
	}

	public void setAttempt_login_count(int attempt_login_count) {
		this.attempt_login_count = attempt_login_count;
	}

	public Date getLast_logined() {
		return last_logined;
	}

	public void setLast_logined(Date last_logined) {
		this.last_logined = last_logined;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public Date getPassword_ch_date() {
		return password_ch_date;
	}

	public void setPassword_ch_date(Date password_ch_date) {
		this.password_ch_date = password_ch_date;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getPlain_password() {
		return plain_password;
	}

	public void setPlain_password(String plain_password) {
		this.plain_password = plain_password;
	}

	public String getValidate_password() {
		return validate_password;
	}

	public void setValidate_password(String validate_password) {
		this.validate_password = validate_password;
	}

	public String getOriginal_password() {
		return original_password;
	}

	public void setOriginal_password(String original_password) {
		this.original_password = original_password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
    
}
