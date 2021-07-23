package com.CS5500.springbootinfrastructure.repos;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DateLogRepository extends CrudRepository<DateLog, Integer> {

    @Query(value = "select d from DateLog d")
    List<DateLog> getJSONDates();

    @Query(value = "select * from type", nativeQuery = true)
    List<Map<String, Object>> getJSONTypes();

    @Query(value = "select * from activity", nativeQuery = true)
    List<Map<String, Object>> getJSONActivities();

    @Query(value = "select * from type where kind like 'move'", nativeQuery = true)
    List<Map<String, Object>> getJSONMoves();

    @Query(value = "select * from type where kind like 'place'", nativeQuery = true)
    List<Map<String, Object>> getJSONPlaces();
}
