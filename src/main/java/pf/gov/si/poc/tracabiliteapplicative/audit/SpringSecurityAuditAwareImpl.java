package pf.gov.si.poc.tracabiliteapplicative.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import pf.gov.si.poc.tracabiliteapplicative.domain.Agent;

import java.util.Optional;

class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()
        || authentication instanceof AnonymousAuthenticationToken) {
      return Optional.of("Unauthenticated user");
    }
    Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();

    Agent authenticatedAgent = new Agent();
    authenticatedAgent.setUsername(jwtPrincipal.getClaimAsString("user_name"));
    authenticatedAgent.setNom(jwtPrincipal.getClaimAsString("family_name"));
    authenticatedAgent.setPrenom(jwtPrincipal.getClaimAsString("given_name"));
    authenticatedAgent.setEmail(jwtPrincipal.getClaimAsString("email"));

    return Optional.of(authenticatedAgent.toString());
  }
}