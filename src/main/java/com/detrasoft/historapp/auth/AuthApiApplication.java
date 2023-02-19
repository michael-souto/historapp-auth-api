package com.detrasoft.historapp.auth;

import com.detrasoft.historapp.auth.domain.entities.*;
import com.detrasoft.historapp.auth.domain.repositories.ProfileRepository;
import com.detrasoft.historapp.auth.domain.repositories.RoleRepository;
import com.detrasoft.historapp.auth.domain.repositories.UserProfileRepository;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@ComponentScan(basePackages = "com.detrasoft")
@SpringBootApplication(scanBasePackages = {"com.detrasoft",})
@EntityScan(basePackages = {"com.detrasoft",})
public class AuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
			RoleRepository roleRepository,
			ProfileRepository profileRepository,
			UserProfileRepository userProfileRepository,
			UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			saveRole(roleRepository, "AZ1C", "Consultar usuário");
			saveRole(roleRepository, "AZ1G", "Operar usuário");
			saveRole(roleRepository, "AZ2C", "Consultar perfil de acesso");
			saveRole(roleRepository, "AZ2G", "Operar perfil de acesso");
			saveRole(roleRepository, "AZ3C", "Consultar permissão");
			saveRole(roleRepository, "AZ3G", "Operar permissão");
			saveUser(profileRepository, userProfileRepository, userRepository, passwordEncoder);
		};
	}

	private void saveRole(RoleRepository roleRepository, String roleCode, String roleName) {
		var role = roleRepository.findByCode(roleCode);
		if (role == null) {
			role = Role.builder().code(roleCode).name(roleName).build();
			roleRepository.save(role);
		}
	}

	private void saveUser(ProfileRepository profileRepository, UserProfileRepository userProfileRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		var userSearched = userRepository.findByEmail("admin@detrasoft.com");
		if (userSearched.isEmpty()) {
			User admin = new User();
			admin.setId(0L);
			admin.setIdDetrasoft(1L);
			admin.setEmail("admin@detrasoft.com");
			admin.setFirstName("Admin");
			admin.setLastName("Detrasoft");
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setType(TypeUser.Admin);
			admin.setBusiness("Detrasoft Systems");

			admin = userRepository.save(admin);
			var userProfile = UserProfile.builder()
					.profile(saveProfile(profileRepository))
					.user(admin)
					.build();
			userProfileRepository.save(userProfile);
		}
	}

	private Profile saveProfile(ProfileRepository profileRepository) {
		var result = profileRepository.findById(1L);
		if (result.isEmpty()) {
			var profile = Profile.builder().name("Default").idDetrasoft(1L).build();
			return profileRepository.save(profile);
		}
		return null;
	}
}
