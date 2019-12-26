package pf.gov.si.poc.tracabiliteapplicative.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Extract the ROLES from the JWT token for a given
 * Keycloak implementation
 * https://stackoverflow.com/questions/58205510/spring-security-mapping-oauth2-claims-with-roles-to-secure-resource-server-endp
 */
public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

  private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
  private final String resourceId;

  public CustomJwtAuthenticationConverter(String resourceId) {
    this.resourceId = resourceId;
  }

  @Override
  public AbstractAuthenticationToken convert(final Jwt source) {
    Collection<GrantedAuthority> authorities = Stream.concat(defaultGrantedAuthoritiesConverter.convert(source)
            .stream(),
        extractResourceRoles(source, resourceId).stream())
        .collect(Collectors.toSet());
    return new JwtAuthenticationToken(source, authorities);
  }

  private static Collection<? extends GrantedAuthority> extractResourceRoles(final Jwt jwt, final String resourceId) {
    Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
    Map<String, Object> resource;
    Collection<String> resourceRoles;

    if (resourceAccess != null && (resource = (Map<String, Object>) resourceAccess.get(resourceId)) != null &&
        (resourceRoles = (Collection<String>) resource.get("roles")) != null)
      return resourceRoles.stream()
          .map(x -> new SimpleGrantedAuthority(x)) //should be under format ROLE_... to match Spring Security "role"
          .collect(Collectors.toSet());
    return Collections.emptySet();
  }
}