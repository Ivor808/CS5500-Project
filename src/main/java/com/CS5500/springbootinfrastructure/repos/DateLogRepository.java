package com.CS5500.springbootinfrastructure.repos;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DateLogRepository extends CrudRepository<DateLog, Integer> {

}
