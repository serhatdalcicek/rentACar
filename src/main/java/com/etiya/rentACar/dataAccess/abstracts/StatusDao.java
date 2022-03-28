package com.etiya.rentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Status;

@Repository //Bunun bir repository veri erişim olduğunu belirtir.
public interface StatusDao extends JpaRepository<Status, Integer> {

	//List<Status> getByStatusId(int id);
}