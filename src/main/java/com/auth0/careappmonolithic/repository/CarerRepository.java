package com.auth0.careappmonolithic.repository;

import com.auth0.careappmonolithic.domain.Carer;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Carer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarerRepository extends JpaRepository<Carer, Long> {}
