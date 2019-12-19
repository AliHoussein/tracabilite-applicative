package pf.gov.si.poc.tracabiliteapplicative.domain;

import javax.persistence.*;

@Entity
@Table(name = "associations")
public class Association extends Auditable {
    @Id
    private Long id;


    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String numeroTahiti;

    @ManyToOne(optional = false)
    private TypeAssociation typeAssociation;

    private Long codeTiers;

    private String sigle;

    private String observations;

}
