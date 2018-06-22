package guru.springframework.spring5webapp.transactionAppRelatedCode.repositories;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
