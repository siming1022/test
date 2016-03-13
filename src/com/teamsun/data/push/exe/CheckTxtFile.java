package com.teamsun.data.push.exe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckTxtFile 
{
	public static void main(String[] args) 
	{
		try
		{
			File f = new File("d://td.dat");
			FileInputStream fis=new FileInputStream(f);
			InputStreamReader isr=new InputStreamReader(fis, "GBK");
			BufferedReader br=new BufferedReader(isr);

			String line = null;
			int count = 0;
			java.util.List<String> ll = new ArrayList<String>();
			while ((line = br.readLine()) != null)
			{
				ll.add(line);
			}

			File f2 = new File("d://hbase.dat");
			FileInputStream fis2=new FileInputStream(f2);
			InputStreamReader isr2=new InputStreamReader(fis2, "GBK");
			BufferedReader br2=new BufferedReader(isr2);
			
			String line2 = null;

			while ((line2 = br2.readLine()) != null)
			{
				if (!ll.contains(line2))
				{
					System.out.println(line2);
				}
			}
			
			
			
			System.out.println(count);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
