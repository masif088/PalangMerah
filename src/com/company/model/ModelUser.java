package com.company.model;

import java.util.Scanner;

import static com.company.Main.sc;

public class ModelUser {

	private String username,password;
	private int level;

	public ModelUser(){
		username=sc.nextLine();
		password=sc.nextLine();
		level=2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordl() {
		return password;
	}

	public void setPasswordl(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
