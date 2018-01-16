package com.example.boot.m.a.easy_notes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotesRepository extends CrudRepository<Notes,Long>{
	

}
