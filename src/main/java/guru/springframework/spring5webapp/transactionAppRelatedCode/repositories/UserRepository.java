package guru.springframework.spring5webapp.transactionAppRelatedCode.repositories;

import guru.springframework.spring5webapp.transactionAppRelatedCode.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
