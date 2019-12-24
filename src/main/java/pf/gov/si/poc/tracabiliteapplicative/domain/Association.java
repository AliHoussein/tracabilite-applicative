package pf.gov.si.poc.tracabiliteapplicative.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "associations")
public class Association extends Auditable {

  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false, unique = true)
  private String numeroTahiti;
}
