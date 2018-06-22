package guru.springframework.spring5webapp.transactionAppRelatedCode.repositories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Author, Long> {
}
