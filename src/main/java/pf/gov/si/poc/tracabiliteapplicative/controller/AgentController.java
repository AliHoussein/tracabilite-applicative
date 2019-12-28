package pf.gov.si.poc.tracabiliteapplicative.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {

  @GetMapping("/me")
  public Authentication getAuthenticatedAgent() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication;
  }
}
