package cn.itcast.web.mail.base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Demo3 {
     private static String[] data = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"}; 
	//����MD5�ĵ�����ܷ�ʽ
	public static void main(String[] args) throws Exception {
		//����
		 String password = "1546562";
	    //md5����
		 String passwordByMd5 = encodeByMd5(password);
		 System.out.println(passwordByMd5);
		 
		  

	}

	private static String encodeByMd5(String password) throws Exception {
		 //����MD5�ļ�����
		 MessageDigest md = MessageDigest.getInstance("md5");
		 //�����ļ���
		   byte[] buff = md.digest(password.getBytes());
		   //���ַ�����ת���ַ���
		return  ArrayToString(buff);
		  
		
	}
    //���ַ�����ת���ַ���
	private static String ArrayToString(byte[] buff) {
		 StringBuffer sb = new StringBuffer();
		for(int i=0;i<buff.length;i++){
			//��ÿ���ַ�ת��ʮ�����Ƶ��ַ���
			  sb.append(bytetoString(buff[i]));
		}
		return sb.toString();
	}
    //��ÿ���ַ�ת��ʮ�����Ƶ��ַ���
	private static String bytetoString(byte b) {
		int temp = b;
		if(temp<0){
			temp = 255+temp;
		}
		int r1 = temp/16;
		int r2 = temp%16;
		/*System.out.println(r1+":"+r2);
		System.out.println(data[r1]+":"+data[r2]);*/
		return data[r1]+data[r2];
	}

}
