package com.TMS.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Admin
 *
 */
public class FileUtility {
/**
 * To fetch data from common property data file
 * @param key
 * @return
 * @throws IOException
 */
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
