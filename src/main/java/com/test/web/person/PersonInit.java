package com.test.web.person;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonInit implements ApplicationRunner{
		private PersonRepository personRepository;
		private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		public PersonInit(PersonRepository personRepository) {
			this.personRepository = personRepository;
		}
		
		@Override
		public void run(ApplicationArguments args) throws Exception {
				long count = personRepository.count();
				if(count == 0) {
					Person person = null ;
				
					String[][] mtx = {{"qwer","1","권혜령","1986-06-10"},
											{"asdf","1","seho","1991-10-28"},
											{"zxcv","1","yeji","1988-12-28"},
											{"1111","1","gohome","1988-12-28"},
											{"1214","1","권혜령","1988-12-28"},
											{"1234","1","kwon HR","1986-06-10"}};
					
					for (int i = 0; i < mtx.length; i++) {
							person = new Person();
							person.setCid(mtx[i][0]);
							person.setPwd(mtx[i][1]);
							person.setName(mtx[i][2]);
							person.setBirthday(df.parse(mtx[i][3]));
							personRepository.save(person);
					}
									
				}
		}
}