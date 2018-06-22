package guru.springframework.spring5webapp.transactionAppRelatedCode.repositories;

import guru.springframework.spring5webapp.transactionAppRelatedCode.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
