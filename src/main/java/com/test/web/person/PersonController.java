package com.test.web.person;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class PersonController {

		@Autowired
		private PersonRepository personRepository;
		@Autowired
		private Person resultPerson;
		
		@RequestMapping("/person")
		public String index() {
			Iterable<Person> all = personRepository.findAll();
			StringBuilder sb = new StringBuilder();
			all.forEach(p-> sb.append(p.getName()+" "));
			return sb.toString();
		}
		
		@RequestMapping("/login")
		public HashMap<String,Object> login(@RequestBody Person person) {
			HashMap<String,Object> map =new HashMap<>();
			System.out.println("로그인 진입 ");
			System.out.println(String.format("UserId: %s" , person.getCid()));
			System.out.println(String.format("pwd: %s" , person.getPwd()));
			
			resultPerson = personRepository.findByCidAndPwd(person.getCid(), person.getPwd());
			if(resultPerson != null ) {
				System.out.println("로그인 성공");
				map.put("result", "SUCCESS");
				map.put("data", resultPerson);
			}else {
				System.out.println("로그인 실패");
				map.put("result", "FAIL");				
				map.put("data", resultPerson);				
			}
			return map;
			
		}
		
		@RequestMapping("/join")
		public HashMap<String,Object> join(@RequestBody Person person) {
			HashMap<String,Object> map =new HashMap<>();
			System.out.println("가입 진입 ");
			personRepository.save(person);			
			if(person != null ) {
				System.out.println("가입 성공");
				map.put("result", "SUCCESS");
			}else {
				System.out.println("가입 실패");
				map.put("result", "FAIL");				
			}   
			return map;
			
		}
	
}
