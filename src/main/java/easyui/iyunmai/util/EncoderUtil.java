package easyui.iyunmai.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;


	public class EncoderUtil {
		
		public static String encodePassword(String password, String username)
		{
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			md5.setEncodeHashAsBase64(false);
			return md5.encodePassword(password, username);
		}
}
