package pf.gov.si.poc.tracabiliteapplicative.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pf.gov.si.poc.tracabiliteapplicative.domain.Association;
import pf.gov.si.poc.tracabiliteapplicative.dto.AssociationDto;
import pf.gov.si.poc.tracabiliteapplicative.service.AssociationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/associations")
public class AssociationController {
    @Autowired
    AssociationService associationService;

    @PreAuthorize("hasRole('ROLE_ASSOCIATIONS_MASTER')")
    @GetMapping
    public List<Association> getAssociations() {
        return associationService.getAssociations();
    }

    @PreAuthorize("hasRole('ROLE_ASSOCIATIONS_MASTER')")
    @PostMapping
    public void createAssociation(@RequestBody AssociationDto associationDto) {
        associationService.add(associationDto);
    }

    @PreAuthorize("hasRole('ROLE_ASSOCIATIONS_MASTER')")
    @GetMapping("/{id}")
    public Association getAssociationById(@PathVariable long id) {
        return associationService.getAssociationById(id);
    }

    @PreAuthorize("hasRole('ROLE_ASSOCIATIONS_MASTER')")
    @PutMapping("/{id}")
    public Association updateAssociation(@PathVariable long id, @RequestBody AssociationDto associationDto) {
        return associationService.updateAssociation(id, associationDto);
    }

    @PreAuthorize("hasRole('ROLE_ASSOCIATIONS_MASTER')")
    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable long id) {
        associationService.delete(id);
    }
}
