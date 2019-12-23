package com.test.web.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class BoardController {


	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping("/")
	public String index() {
		Iterable<Board> all = boardRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(b-> sb.append(b.getBrdnum()+" "));
		return sb.toString();
	}


	
	
}
