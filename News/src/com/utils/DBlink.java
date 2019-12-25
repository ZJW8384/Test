package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.junit.Test;

public class DBlink {
	private  static DBlink db;
	private String URL;
	private String Driver;
	private String pwd;
	private String user;
	public String getURL() {
		return URL;
	}
	
	public String getDriver() {
		return Driver;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getUser() {
		return user;
	}
	
	private DBlink() {
		
	}
	public static DBlink instance() throws Exception {
		if(db==null) {
			db=new DBlink();
			db.init();
		}
		return db;
	}
	
	private void init() throws Exception{
		Properties prop=new Properties();
		String file = this.getClass().getResource("").getPath();
		String path=file.replace("com/utils/","")+"resource/jdbc.properties";
		prop.load(new FileInputStream(new File(path)));
		this.Driver=prop.getProperty("driver");
		this.pwd=prop.getProperty("password");
		this.URL=prop.getProperty("url");
		this.user=prop.getProperty("user");
	}

}
