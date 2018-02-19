package com.util;

public class EncryptionUtil 
{
	public String encrypt(String pwd)
	{
		StringBuffer sb=new StringBuffer(pwd);
		StringBuffer s=sb.reverse();
		int length=s.length();
	
		String s1="";
		for(int i=0; i<s.length(); i++)
		{
			char a=(char) (s.charAt(i)+length);
			s1=s1+a;
		}
	
		return s1;
	}
}
