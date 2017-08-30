package com.revature.application.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Long> {
	List<Placement> findByDate(Date date);

}
