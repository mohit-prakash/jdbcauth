package com.mps.genpwd;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClassToGenEncPwd {

	public static void main(String[] args) {
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		String ePwd = enc.encode("p0510152025");
		System.out.println(ePwd);
	}

}
