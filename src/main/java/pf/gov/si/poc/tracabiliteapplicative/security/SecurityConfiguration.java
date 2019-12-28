package pf.gov.si.poc.tracabiliteapplicative.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  private static final String RESSOURCE_ID_FOR_ROLE_AUTHORISATIONS = "idp-poc-sipf";

  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    http
        .csrf().ignoringAntMatchers("/api/**")
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .formLogin().disable()
        .cors()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .anyRequest().authenticated()
        .and()
        .oauth2ResourceServer().jwt()
        .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter(RESSOURCE_ID_FOR_ROLE_AUTHORISATIONS));
  }
}
