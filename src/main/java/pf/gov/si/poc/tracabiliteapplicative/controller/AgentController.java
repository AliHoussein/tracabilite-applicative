package pf.gov.si.poc.tracabiliteapplicative.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pf.gov.si.poc.tracabiliteapplicative.domain.Agent;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {

  @GetMapping("/me")
  public Jwt getAuthenticatedAgent() {
//    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return jwt;
  }

}
