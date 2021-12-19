package com.smart;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SmartcontactmanagerApplication implements CommandLineRunner  {
	
	@Autowired
	private BCryptPasswordEncoder bryBCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SmartcontactmanagerApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//ONE TIME Task- Bootstrap all the master data and other pre-requisite data and load in system during application startup for the first time
		onboardAdminUser();
		//loadCoursesAndTopicsMasterData(); //populate in tables : course_master and topic_master
	}
	private void onboardAdminUser() {
		String userName = "admin_support@gmail.com";
		User user = userRepository.getUserByUserName(userName);
		if(user == null) {
			user = new User();
			user.setName("admin");
			user.setEnabled(true);
			user.setRole("ROLE_ADMIN");
			user.setImageUrl("default.png");
			user.setAbout("Administrator");
			user.setEmail(userName);
			user.setPassword(this.bryBCryptPasswordEncoder.encode("admin123"));
			userRepository.save(user);
		}
	}
	private void encryptDecryptLogic() {
//		String str="deepshikha";
//		String encode = this.bryBCryptPasswordEncoder.encode(str);
//		System.out.println(encode);
//		String str1="deepshikha";
//		String encode2 = this.bryBCryptPasswordEncoder.encode(str1);
//		System.out.println(this.bryBCryptPasswordEncoder.matches("deepa",encode));
	}
}
