package pf.gov.si.poc.tracabiliteapplicative.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pf.gov.si.poc.tracabiliteapplicative.service.AssociationAuditService;

@RestController
@RequestMapping("/api/v1/associations")
public class AssociationAuditController {
    @Autowired
    AssociationAuditService associationAuditService;

    @GetMapping("/audit")
    public String getAllAssociationsChange() {
        return associationAuditService.getAssociationsChange();
    }

    @GetMapping("/{id}/audit")
    public String getAssociationChangeById(@PathVariable long id) {
        return associationAuditService.getAssociationChangeById(id);
    }
}
