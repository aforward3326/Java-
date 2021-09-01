package tw.com.order.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestMain {

	public static void main(String[] args) {
		BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
		String pass="admin123";
		String epass="$2a$10$YO5loeB0jNv482fE2e9uoO3eOsK6ouqe/CTIaxKNzLsWStfhLEYrS";
		boolean getpass=encode.matches(pass, epass);
		System.out.println(getpass);
	}

}
