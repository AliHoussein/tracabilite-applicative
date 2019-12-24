package pf.gov.si.poc.tracabiliteapplicative.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pf.gov.si.poc.tracabiliteapplicative.domain.Association;

@Repository
public interface AssociationRepository extends CrudRepository<Association, Long> {
}
