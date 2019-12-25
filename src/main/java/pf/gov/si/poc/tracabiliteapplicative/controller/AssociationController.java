package pf.gov.si.poc.tracabiliteapplicative.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import pf.gov.si.poc.tracabiliteapplicative.dto.AssociationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pf.gov.si.poc.tracabiliteapplicative.domain.Association;
import pf.gov.si.poc.tracabiliteapplicative.service.AssociationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/associations")
public class AssociationController {
    @Autowired
    AssociationService associationService;

    @GetMapping
    public List<Association> getAssociations() {
        return associationService.getAssociations();
    }

    @PostMapping
    public void createAssociation(@RequestBody AssociationDto associationDto) {
        associationService.add(associationDto);
    }

    @GetMapping("/{id}")
    public Association getAssociationById(@PathVariable long id) {
        return associationService.getAssociationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable long id) {
        associationService.delete(id);
    }
}
