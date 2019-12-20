package com.test.web.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class PersonController {

		@Autowired
		private PersonRepository personRepository;
		
		@RequestMapping("/")
		public String index() {
			Iterable<Person> all = personRepository.findAll();
			StringBuilder sb = new StringBuilder();
			all.forEach(p-> sb.append(p.getName()+" "));
			return sb.toString();
		}
		
		@RequestMapping("/login")
		public Person login(@RequestBody Person person) {
			System.out.println("로그인 진입 ");
			System.out.println(String.format("UserId: %s" , person.getCid()));
			System.out.println(String.format("pwd: %s" , person.getPwd()));
			
			return person;
			
		}
	
}
