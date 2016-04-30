package com.daykm.dao;

import com.daykm.domain.Button;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ButtonRepo extends CrudRepository<Button, Integer> {
	List<Button> findAll();
	Button save(Button b);
}
