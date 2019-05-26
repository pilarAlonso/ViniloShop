package com.demodisco.demodisco.Repositories;

import com.demodisco.demodisco.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
