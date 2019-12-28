package pf.gov.si.poc.tracabiliteapplicative.repository;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pf.gov.si.poc.tracabiliteapplicative.domain.Association;

@Repository
@JaversSpringDataAuditable
public interface AssociationRepository extends CrudRepository<Association, Long> {
}
