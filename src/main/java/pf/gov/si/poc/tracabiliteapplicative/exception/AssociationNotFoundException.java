package pf.gov.si.poc.tracabiliteapplicative.exception;

public class AssociationNotFoundException extends NotFoundException {
    public AssociationNotFoundException(long id) {
        super(String.format("L'association ayant l'identifiant %s n'existe pas", id));
    }
}
