package pf.gov.si.poc.tracabiliteapplicative.service;

import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pf.gov.si.poc.tracabiliteapplicative.domain.Association;
import pf.gov.si.poc.tracabiliteapplicative.repository.AssociationRepository;

import java.util.List;

@Component
public class AssociationAuditService {
  @Autowired
  Javers javers;

  @Autowired
  AssociationService associationService;

  public String getAssociationsChange() {
    QueryBuilder jqlQuery = QueryBuilder.byClass(Association.class);
    List<Change> changes = javers.findChanges(jqlQuery.build());
    return javers.getJsonConverter().toJson(changes);
  }

  public String getAssociationChangeById(long id) {
    Association association = associationService.getAssociationById(id);
    QueryBuilder jqlQuery = QueryBuilder.byInstance(association).withChildValueObjects();
    List<Change> changes = javers.findChanges(jqlQuery.build());
    return javers.getJsonConverter().toJson(changes);
  }
}
