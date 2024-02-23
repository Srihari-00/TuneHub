package com.example.demo.entity;

public class ForgotPassword 
{
	String email;
	String password;
	String re_password;
	String otp;
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForgotPassword(String email, String password, String re_password, String otp) {
		super();
		this.email = email;
		this.password = password;
		this.re_password = re_password;
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "ForgotPassword [email=" + email + ", password=" + password + ", re_password=" + re_password + ", otp="
				+ otp + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRe_password() {
		return re_password;
	}
	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
}
