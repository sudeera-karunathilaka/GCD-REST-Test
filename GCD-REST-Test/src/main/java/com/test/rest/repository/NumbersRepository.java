package com.test.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.rest.model.GCDNumber;

/**
 * The Interface NumbersRepository. Expose all operations related to Numbers
 */
@Repository
public interface NumbersRepository extends JpaRepository<GCDNumber, Long> {

}
