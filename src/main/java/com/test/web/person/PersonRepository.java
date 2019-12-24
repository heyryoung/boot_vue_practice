package com.test.web.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	public Person findByCidAndPwd(String cid, String pwd);
	public Person findByCid(String cid);
	@Transactional
	public void removeByCidAndPwd(String cid, String pwd);

}
