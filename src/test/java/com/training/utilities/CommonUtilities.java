package com.training.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.training.utilities.Constants.APPLICATION_PROPERTIES;
import static com.training.utilities.Constants.USER_DIR;

public class CommonUtilities {
	
	public String getApplicationProperty(String key) throws IOException {
		Properties properties = new Properties();
		String filePath = USER_DIR + File.separator + APPLICATION_PROPERTIES;
		FileInputStream inputFile = new FileInputStream(filePath);
		properties.load(inputFile);
		String value = properties.getProperty(key);
		System.out.println("File Path : "+value);
		System.out.println("User Directory : "+USER_DIR);
		inputFile.close();
		return value;
	}
}
