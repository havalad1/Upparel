package com.scm.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class used to define method associated to property file
 * @author HP
 *
 */
public class PropertyFileFetchUtility {
	private Properties p=null;
	private FileInputStream fisproperty=null;
	/**
	 * this method used to fetch data from property file
	 * @param propertypath
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String propertypath,String key) {
		p=new Properties();
		try {
			fisproperty=new FileInputStream(propertypath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			p.load(fisproperty);
			
		} catch (IOException e) {
			
		}
		String value = p.getProperty(key);
		return value;
		
	}

}
