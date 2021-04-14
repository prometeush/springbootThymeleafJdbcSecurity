package com.project.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AnwendungPasswordencoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder b1=new BCryptPasswordEncoder();
		String s1="12345";
		System.out.println(b1.encode(s1));

	}

}
