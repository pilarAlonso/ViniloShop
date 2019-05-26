package com.demodisco.demodisco.Repositories;

import com.demodisco.demodisco.Entities.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViniloRepository extends JpaRepository<Vinilo,Long> {

}
