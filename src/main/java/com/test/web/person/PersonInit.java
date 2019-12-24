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
				
					String[][] mtx = {{"aaaa","1","권혜령","1986-06-10","M","1","1","100"},
											{"bbbb","1","seho","1991-10-28","M","1","1","100"},
											{"cccc","1","yeji","1988-12-28","M","1","1","100"},
											{"dddd","1","gohome","1988-12-28","M","1","1","100"},
											{"eeee","1","권혜령","1988-12-28","M","1","1","100"},
											{"ffff","1","seho","1991-10-28","M","1","1","100"},
											{"gggg","1","yeji","1988-12-28","M","1","1","100"},
											{"hhhh","1","gohome","1988-12-28","M","1","1","100"},
											{"iiii","1","권혜령","1988-12-28","M","1","1","100"},
											{"jjjj","1","kwon HR","1986-06-10","M","1","1","100"}};
					
					for (int i = 0; i < mtx.length; i++) {
							person = new Person();
							person.setCid(mtx[i][0]);
							person.setPwd(mtx[i][1]);
							person.setName(mtx[i][2]);
							person.setBirthday(df.parse(mtx[i][3]));
							person.setGender(mtx[i][4]);
							person.setHak(Integer.parseInt(mtx[i][5]));
							person.setBan(Integer.parseInt(mtx[i][6]));
							person.setScore(Integer.parseInt(mtx[i][7]));
							System.out.println(person.toString());
							personRepository.save(person);
					}
									
				}
		}
}