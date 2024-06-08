package com.api.model;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

public class baseClass {

	public static Properties prop = new Properties();

	public static String setProperties() throws IOException {

//prop = new Properties(); 

		FileInputStream file = new FileInputStream("src\\test\\java\\Property FIle\\config.properties");

		prop.load(file);

		String URL = prop.getProperty("baseURL");

//System.out.println(URL); 

		return URL;

	}

	public static void main(String[] args) throws IOException {

		System.out.println(setProperties());

	}

}
