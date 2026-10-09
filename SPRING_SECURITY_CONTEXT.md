# Contexto: Spring Security + JWT (repo de referencia)

Repo de referencia: `C:\Users\Santiago\Desktop\security`
Úsalo para tomar la **estructura**, no para copiarlo tal cual: tiene fallos conocidos (ver sección 5).

## 1. Stack

- Spring Boot **4.0.2** → Spring Security **7**, Jackson 3, Java 17
- JJWT **0.12.3** (`jjwt-api`, `jjwt-impl`, `jjwt-jackson`)
- MySQL + JPA, MapStruct, Lombok, springdoc-openapi 3.0.0
- Arquitectura hexagonal: `domain` → `application` → `infrastructure`

## 2. Modelo de autenticación

- **Stateless**: no hay sesión HTTP y CSRF está desactivado.
- **Access token**: un JWT HS256 que dura 15 min y lleva estos claims:
  - `sub` = userId (UUID)
  - `email`
  - `roles` = lista de authorities, por ejemplo `["ROLE_USER"]`
- **Refresh token**: un UUID aleatorio guardado en BD (`refresh_tokens`), que dura 7 días y se puede revocar.
- **Principal** en el `SecurityContext`: el `UUID` del usuario. En los controladores se obtiene con `(UUID) authentication.getPrincipal()`.
- **Roles**: `ROLE_USER`, `ROLE_ADMIN` y `ROLE_MODERATOR`. Los crea `DataInitializer` y `data.sql`. Al registrarse, el usuario recibe `ROLE_USER`.
- **Autorización por método**: `@EnableMethodSecurity` y `@PreAuthorize("hasRole('ADMIN')")`.

## 3. Archivos clave (`src/main/java/com/bkseducate/securityapp/`)

| Archivo | Rol |
|---|---|
| `infrastructure/security/SecurityConfig.java` | `SecurityFilterChain`, CORS, rutas públicas y `BCryptPasswordEncoder` |
| `infrastructure/security/JwtAuthenticationFilter.java` | `OncePerRequestFilter`: lee `Authorization: Bearer`, valida el token y llena el `SecurityContext` |
| `infrastructure/security/JwtTokenService.java` | Implementa el puerto `TokenService`: genera y valida JWT y extrae los roles |
| `infrastructure/security/PasswordServiceImpl.java` | Implementa el puerto `PasswordService` sobre `PasswordEncoder` |
| `domain/ports/TokenService.java`, `PasswordService.java` | Puertos: el dominio no depende de Spring Security |
| `application/usecase/*UseCase.java` | Casos de uso: Login, Register (CreateUser), Refresh, Logout, ChangePassword, GetCurrentUser, AssignRole |
| `infrastructure/persistence/adapters/in/rest/AuthController.java` | `/auth/*` |
| `infrastructure/persistence/adapters/in/rest/UserController.java` | `/users/{id}/roles` (solo ADMIN) |
| `infrastructure/exception/GlobalExceptionHandler.java` | Convierte las excepciones de dominio en respuestas HTTP |
| `src/main/resources/application.yml` | `jwt.secret`, `jwt.access-token-expiration` y `jwt.refresh-token-expiration` |

## 4. Endpoints

| Método | Ruta | Acceso |
|---|---|---|
| POST | `/auth/register` | público |
| POST | `/auth/login` | público → `{accessToken, refreshToken, expiresIn}` |
| POST | `/auth/refresh` | público |
| POST | `/auth/logout` | autenticado |
| GET | `/auth/me` | autenticado |
| PUT | `/auth/change-password` | autenticado |
| PUT | `/users/{userId}/roles` | `ROLE_ADMIN` |
| — | `/swagger-ui/**`, `/v3/api-docs/**`, `/actuator/health` | público |

## 5. Fallos conocidos del repo de referencia: NO replicar

1. **Falta `AuthenticationEntryPoint`.** Los requests no autenticados reciben 403 vacío. Debe responder **401 con JSON**.
2. **Falta `AccessDeniedHandler`** en la cadena de filtros. Debe responder 403 con JSON. `@RestControllerAdvice` no ve las excepciones que ocurren dentro de los filtros.
3. **El filtro JWT oculta los errores del token** con `catch (Exception)`: un token expirado o inválido acaba como 403 genérico. Hay que distinguir los casos y delegar en el entry point.
4. **`/error` no está en `permitAll`.** Por eso los 404 y 500 se muestran como 403.
5. **El filtro JWT es `@Component`** y Spring Boot lo registra también como filtro del servlet container. Hay que desactivarlo con `FilterRegistrationBean#setEnabled(false)` o no declararlo como bean.
6. **`/auth/logout` exige un access token válido**, así que con el token expirado no se puede cerrar sesión.
7. **Enumeración de usuarios.** El login responde 404 si el email no existe. Debe responder siempre 401 genérico.
8. **Secreto JWT por defecto** en `application.yml`. Debe ser obligatorio por variable de entorno, de 256 bits como mínimo.
9. **Logout** no valida que el refresh token pertenezca al usuario autenticado.
10. **Refresh tokens:** no se rotan, no se revocan al cambiar la contraseña, y la expiración está fija en el código (`plusDays(7)`) en lugar de usar `jwt.refresh-token-expiration`.
11. **Roles del token:** `extractRoles` crea objetos `Role` con un UUID aleatorio, y `Role.equals` compara por id. Además, el token se parsea dos veces por request; conviene parsearlo una vez.
12. **CORS** con `allowedOrigins("*")`. En producción hay que restringir los orígenes.
13. **Lombok 1.18.30** no compila con JDK 21 o superior. Hay que alinear las versiones con el JDK que se use.
14. **Credenciales `root/1234` y logging `TRACE` de SQL** en `application-dev.yml`. Ese logging expone los hashes de contraseña.

## 6. Recomendaciones al implementar en otro proyecto

- Verificar la versión de Spring Boot y Spring Security del proyecto destino. Las APIs de Security 6 y 7 difieren en algunos detalles.
- Mantener la seguridad detrás de puertos (`TokenService`, `PasswordService`) si el proyecto usa arquitectura hexagonal.
- Configurar un `SecurityFilterChain` con:
  - `csrf` desactivado y `STATELESS`
  - `exceptionHandling(entryPoint + accessDeniedHandler)`
  - `/error` y los endpoints de auth en `permitAll`
- Valorar `spring-boot-starter-oauth2-resource-server` (`JwtDecoder`/`NimbusJwtDecoder`) como alternativa a un filtro JWT propio. Ya maneja el 401 y el header `WWW-Authenticate`.
- Proponer un plan antes de escribir código.
