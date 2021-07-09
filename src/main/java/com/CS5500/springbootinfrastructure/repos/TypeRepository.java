package com.CS5500.springbootinfrastructure.repos;

import com.CS5500.springbootinfrastructure.dao.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository<T extends Type>  extends CrudRepository<T, Integer> {

}
