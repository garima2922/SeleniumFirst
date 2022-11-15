package com.abc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		File src = new File ("src\\test\\resources\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
}
