package pf.gov.si.poc.tracabiliteapplicative.service;

import pf.gov.si.poc.tracabiliteapplicative.dto.AssociationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pf.gov.si.poc.tracabiliteapplicative.domain.Association;
import pf.gov.si.poc.tracabiliteapplicative.repository.AssociationRepository;
import pf.gov.si.poc.tracabiliteapplicative.exception.AssociationNotFoundException;

import java.util.List;
import java.util.Optional;

@Component
public class AssociationService {
  @Autowired
  AssociationRepository associationRepository;

  public void add(AssociationDto associationDto) {
    associationRepository.save(toEntity(new Association(), associationDto));
  }

  public void delete(long id) {
    associationRepository.deleteById(id);
  }

  public List<Association> getAssociations() {
    return (List<Association>) associationRepository.findAll();
  }

  public Association getAssociationById(long id) {
    Optional<Association> optionalAssociation = associationRepository.findById(id);
    return optionalAssociation.orElseThrow(() -> new AssociationNotFoundException(id));
  }

  public Association updateAssociation(long id, AssociationDto associationDto) {
    Association association = associationRepository.findById(id)
        .orElseThrow(() -> new AssociationNotFoundException(id));

    toEntity(association, associationDto);
    associationRepository.save(association);

    return association;
  }

  private Association toEntity(Association association, AssociationDto associationDto) {
    association.setNom(associationDto.getNom());
    association.setNumeroTahiti(associationDto.getNumeroTahiti());
    return association;
  }
}
