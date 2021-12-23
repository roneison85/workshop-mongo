package com.lhsistemas.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lhsistemas.mongo.domain.Post;
import com.lhsistemas.mongo.domain.User;
import com.lhsistemas.mongo.repositories.PostRepository;
import com.lhsistemas.mongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, format.parse("22/12/2021"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, format.parse("23/12/2021"), "Bom dia!", "Acordei feliz hoje!", maria);
		
		postRepository.deleteAll();
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
