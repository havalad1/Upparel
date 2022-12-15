package com.scm.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility 
{
	public String getDateTime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
		String d=sdf.format(date);
		return d;
	}
}
