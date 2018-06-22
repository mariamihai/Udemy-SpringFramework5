package guru.springframework.spring5webapp.transactionAppRelatedCode.repositories;

import guru.springframework.spring5webapp.transactionAppRelatedCode.model.Recurrence;
import org.springframework.data.repository.CrudRepository;

public interface RecurrenceRepository extends CrudRepository<Recurrence, Long> {
}
