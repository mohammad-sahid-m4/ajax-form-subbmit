package com.metafour.repo;


import org.springframework.data.repository.CrudRepository;

import com.metafour.model.*;

public interface StudentRepository extends CrudRepository<Student,Long>{

}
