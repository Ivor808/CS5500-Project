package com.CS5500.springbootinfrastructure.repos;

import com.CS5500.springbootinfrastructure.dao.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
