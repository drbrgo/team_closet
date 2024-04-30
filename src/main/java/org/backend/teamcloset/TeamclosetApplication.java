package org.backend.teamcloset;

import org.backend.teamcloset.data.UserRepository;
import org.backend.teamcloset.entities.Role;
import org.backend.teamcloset.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TeamclosetApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TeamclosetApplication.class, args);
	}

	//logic to create admin user
	public void run(String... args) {
		UserEntity adminAccount = userRepository.findByRole(Role.ADMIN);
		if(adminAccount == null){
			UserEntity user = new UserEntity();
			user.setUsername("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("${ADMIN_PASS"));
			userRepository.save(user);
		}
	}

}
