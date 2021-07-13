# OAuth 2.0 Resource Server with Spring Security

Spring Security OAuth2 Boot simplifies protecting your resources using Bearer Token authentication.

- Two different token formats:
  - JWT
  - Opaque

![keycloak-auth-flow](https://user-images.githubusercontent.com/3072734/125256072-09ad7080-e337-11eb-93d1-d192484b4120.png)

## Description
### Dependencies
- org.springframework.boot
  - `spring-boot-starter-oauth2-resource-server`

### Application Configuration
- `spring.security.oauth2.resourceserver.jwt.issuer-uri`
  - The URI that it asserts as its Issuer Identifier
  - Authorization Server's endpoint
  - **issuer** from the following JSON
- `spring.security.oauth2.resourceserver.jwt.jwk-set-uri`
  - Authorization Server's endpoint exposing public keys
  - **jwks_uri** from the following JSON

```shell
$ curl -X GET http://localhost:8083/auth/realms/shinyay/.well-known/openid-configuration| jq .
```
```json
{
  "issuer": "http://localhost:8083/auth/realms/shinyay",
  "authorization_endpoint": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/auth",
  "token_endpoint": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/token",
  "introspection_endpoint": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/token/introspect",
  "userinfo_endpoint": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/userinfo",
  "end_session_endpoint": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/logout",
  "jwks_uri": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/certs",
  "check_session_iframe": "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/login-status-iframe.html"
```

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8083/auth/realms/shinyay
          jwk-set-uri: http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/certs
```

### Security Configuration
Security configuration class which extends WebSecurityConfigurerAdapter class

- Access with `read scope`
  - `hasAuthority("SCOPE_read")`
- Access with `write scope`
  - `hasAuthority("SCOPE_write")`

```kotlin
fun configure(http: HttpSecurity?) {
    http
        ?.authorizeRequests { authz ->
            authz
                .antMatchers(HttpMethod.GET, "/api/v1/employees/**").hasAuthority("SCOPE_read")
                .antMatchers(HttpMethod.POST, "/api/v1/employees").hasAuthority("SCOPE_write")
                .anyRequest().authenticated()
        }
}
```

**read** and **write** scope
![client-scope](https://user-images.githubusercontent.com/3072734/125379261-2a270a80-e3cb-11eb-919b-6a658cc9d641.png)

scope mapping to client
![scope-mapping](https://user-images.githubusercontent.com/3072734/125379323-432fbb80-e3cb-11eb-88d9-5d27a472f090.png)

oauth2ResourceServer() DSL to indicate the type of tokens
```kotlin
fun configure(http: HttpSecurity?) {
    http
        ?.oauth2ResourceServer { oauth2 -> oauth2.jwt() }
}
```

## Demo
Retrieve Access Token
```shell
$ set -x TOKEN (curl -X POST "http://localhost:8083/auth/realms/shinyay/protocol/openid-connect/token" --data "grant_type=client_credentials&client_secret=$CLIENT_SECRET&client_id=shinyay-api"|jq -r .access_token)
```

POST Data with Access Token
```shell
$ curl -v -X POST -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -d '{"name":"oauth2"}' localhost:8081/resource-server/api/v1/employees
```

GET Data with Access Token
```shell
$ curl -v -X GET -H "Authorization: Bearer $TOKEN" localhost:8081/resource-server/api/v1/employees
```
## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

- [Spring Security OAuth 2.0](https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html5/)
- [OAuth 2 Developers Guide](https://projects.spring.io/spring-security-oauth/docs/oauth2.html)
- [OAuth2 Boot - Resource Server](https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html5/#boot-features-security-oauth2-resource-server)

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
