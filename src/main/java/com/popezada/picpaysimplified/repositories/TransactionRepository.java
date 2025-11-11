package com.popezada.picpaysimplified.repositories;

import com.popezada.picpaysimplified.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
