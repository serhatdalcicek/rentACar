package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

   // List<Customer> getByCustomerId(int id);
    //Boolean ExistByCustomerId(int customerId);
}
