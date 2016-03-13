package com.teamsun.data.push.exe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckDataMain {

	public static final String TWENTY_FILENAME_REGEX = ">(.{20}.dat)<"; // Q3005_20141204220303.dat
	public static final String FOURTEEN_FILENAME_REGEX = ">(.{14}.dat)<"; // 20141212130014.dat
	  
	public static void main(String[] args) 
	{
		try {
			String url = "http://10.3.18.11:10001/20002/";//"http://10.3.51.223:10001/";
	        URL u = new URL(url);
	        InputStream is = u.openStream();
	        InputStreamReader isr = new InputStreamReader(is, "GBK");
	        
	        BufferedReader br = new BufferedReader(isr);
	        StringBuffer sb = new StringBuffer();
	        String line = "";
	        
	        int count = 0;
	        while ((line = br.readLine()) != null) 
	        {
	        	Pattern p_20 = Pattern.compile(TWENTY_FILENAME_REGEX);
	            Matcher m_20 = p_20.matcher(line);
	            while (m_20.find()) {
	            	String fileName = m_20.group(1);
	            	System.out.println("find file: " + fileName);
	            	readDat(url + "/" + fileName);
	            	count++;
	            }
	            Pattern p_14 = Pattern.compile(FOURTEEN_FILENAME_REGEX);
	            Matcher m_14 = p_14.matcher(line);
	            while (m_14.find()) {
	            	String fileName = m_14.group(1);
	            	System.out.println("find file: " + fileName);
	            	readDat(url + "/" + fileName);
	            	count++;
	            }
	        }
	        
	        System.out.println("MWAY FILE COUNT: " + count);
	        
	        br.close();
	        isr.close();
	        is.close();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
		
		System.out.println("end");

	}
	
	private static void readDat(String url) throws Exception
	{
		/*File f = new File("/root/wj/result_41000100.txt");
		InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "GBK");
		BufferedReader br = new BufferedReader(isr);
		List<String> list = new ArrayList<String>();
		
		String mailNum = "";
		
		while ((mailNum = br.readLine()) != null)
		{
			list.add(mailNum);
		}*/
		
		
		try {
//			System.out.println(url);
			if (url.contains("20151115") || url.contains("20151116") || url.contains("20151117") || url.contains("20151118"))
			{
				
			}
	        URL u = new URL(url);
	        InputStream is = u.openStream();
	        InputStreamReader isr2 = new InputStreamReader(is, "GBK");
	        
	        BufferedReader br2 = new BufferedReader(isr2);
	        StringBuffer sb = new StringBuffer();
	        String line = "";
	        
	        int count = 0;
	        while ((line = br2.readLine()) != null) 
	        {
//	        	System.out.println(line);
	        	String[] temp = line.split("\t");
//	        	System.out.println(temp[1]);
	        	/*if ("1082650232406".equals(temp[1]))
	        	{
	        		System.out.println("error: " + line);
	        	}*/
	        	count++;
	        }
	        
	        System.out.println(url + " count : " + count);
	        
	        br2.close();
	        isr2.close();
	        is.close();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}

}
