package com.test.web.board;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository  extends CrudRepository<Board, Long>{



}
