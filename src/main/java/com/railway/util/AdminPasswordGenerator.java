package com.railway.util;

import org.mindrot.jbcrypt.BCrypt;

public class AdminPasswordGenerator {

	public static void main(String[] args) {

		String password = "admin123";

		String hash = BCrypt.hashpw(password, BCrypt.gensalt());

		System.out.println(hash);

	}

}