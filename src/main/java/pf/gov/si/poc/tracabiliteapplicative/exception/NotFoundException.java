package pf.gov.si.poc.tracabiliteapplicative.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1186647478381981101L;

    public NotFoundException(final String message) {
        super(message);
    }
}
