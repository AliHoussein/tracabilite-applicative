package pf.gov.si.poc.tracabiliteapplicative.domain;

import lombok.Data;

@Data
public class Agent {

  private String username;
  private String nom;
  private String prenom;
  private String email;

  @Override
  public String toString() {
    return String.format("Agent %s %s (%s / %s)", prenom, nom, username, email);
  }
}
