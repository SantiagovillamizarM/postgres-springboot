# Tarea: DDD + Arquitectura Hexagonal con Spring Boot

> **Si eres una IA leyendo esto:** este documento explica una tarea universitaria. Actúa como tutor: explica, revisa el código que te muestre y corrige errores, pero no generes todo el código por mí salvo que te lo pida. Responde en español. Cuando termines de leer, haz un resumen corto de lo que entendiste y espera a que te pase el script SQL de la primera tabla.

## 1. ¿Qué pidió el profesor?

> *"Construir la capa de dominio, aplicación e infraestructura de cada bounded context de la base de datos."*

En palabras simples: **cada tabla de la base de datos es un "bounded context"**, y por cada tabla hay que crear sus clases en las 3 capas. El profesor nos dio un proyecto de ejemplo (`demo-ddd`) con **una sola tabla hecha: `countries`**. El trabajo es **copiar ese mismo patrón para todas las tablas** (52 en nuestra base de datos), adaptándolo a las columnas reales de cada una.

## 2. La idea de la arquitectura hexagonal

El proyecto está dividido en 3 módulos de Maven, y **cada uno solo puede conocer al de su derecha**:

```
infrastructure  ──►  application  ──►  domain
(Spring, JPA,        (casos de uso)    (reglas del negocio,
 REST, BD)                              Java puro)
```

| Capa | Qué va ahí | Qué NO puede tener |
|---|---|---|
| **domain** | El "modelo" del negocio: el agregado (ej. `Country`), su ID, sus eventos, su excepción y la **interfaz** del repositorio (el "puerto"). | Nada de Spring, JPA, Lombok ni anotaciones. Java puro. |
| **application** | Los casos de uso: registrar, buscar por id, listar, actualizar y eliminar. Usan la interfaz del repositorio sin saber cómo está implementada. | Nada de Spring ni de infraestructura. Son clases normales. |
| **infrastructure** | Todo lo "técnico": el controller REST, la entidad JPA, el repositorio JPA, el adaptador que implementa el puerto del dominio y la configuración de beans. | — |

La gracia: el dominio no sabe que existe una base de datos ni una API. Si mañana cambias PostgreSQL por otra cosa, solo tocas `infrastructure`.

## 3. Qué archivos lleva cada tabla (≈24)

Ejemplo con `countries` → paquete `country`, clase `Country`:

**domain** (`com.tarea.domain.country`)
| Archivo | Para qué sirve |
|---|---|
| `model/aggregate/Country.java` | El agregado. Constructor **privado** y 3 métodos: `register(...)` crea uno nuevo (genera el ID y registra el evento), `restore(...)` lo reconstruye desde la BD, `update(...)` modifica los datos. Getters estilo `name()`. Hereda de `AggregateRoot`. |
| `model/valueobject/CountryId.java` | `record CountryId(UUID value)` con `generate()`. |
| `event/CountryRegisteredEvent.java`, `CountryUpdatedEvent.java`, `CountryDeletedEvent.java` | Records que implementan `DomainEvent`. |
| `exception/CountryNotFoundException.java` | Excepción cuando no existe. |
| `port/repository/CountryRepository.java` | **Interfaz** con `save`, `findById`, `findAll`, `delete`. |

**application** (`com.tarea.application.country`)
| Archivo | Para qué sirve |
|---|---|
| `command/RegisterCountryCommand.java`, `UpdateCountryCommand.java` | Records con los datos que llegan para crear/actualizar. |
| `dto/CountryResponse.java` | Record con lo que se devuelve. |
| `exception/CountryNotFoundApplicationException.java` | Hereda de `ApplicationException`. |
| `usecase/Register…`, `GetById…`, `List…`, `Update…`, `Delete…UseCase.java` | Un caso de uso por operación. Reciben `CountryRepository` por constructor y tienen un método `execute(...)`. |

**infrastructure** (`com.tarea.infrastructure.country`)
| Archivo | Para qué sirve |
|---|---|
| `adapters/in/rest/controllers/CountryController.java` | `@RestController` en `/api/countries` con POST, GET, GET `/{id}`, PUT `/{id}` y DELETE `/{id}`. |
| `adapters/in/rest/dtos/CreateCountryRequest.java`, `UpdateCountryRequest.java` | Records con validaciones (`@NotBlank`, `@Size`…). |
| `adapters/out/persistence/entity/CountryJpaEntity.java` | La `@Entity` que representa la tabla. |
| `adapters/out/persistence/repositories/CountryJpaRepository.java` | `extends JpaRepository<CountryJpaEntity, UUID>`. |
| `adapters/out/persistence/repositories/CountryRepositoryAdapter.java` | **Implementa** la interfaz `CountryRepository` del dominio usando el JPA repository. |
| `adapters/out/persistence/mappers/CountryPersistenceMapper.java` | Convierte `Country` ⇄ `CountryJpaEntity` (`toJpa` / `toDomain`). |
| `config/CountryBeansConfig.java` | `@Configuration` que crea con `@Bean` el mapper, el adapter y los 5 casos de uso (por eso los casos de uso no llevan `@Service`). |

**Compartidos (se crean una sola vez):** `domain/common/model/AggregateRoot.java`, `domain/common/event/DomainEvent.java`, `application/common/exception/ApplicationException.java`.

## 4. El flujo de una petición

```
POST /api/countries
  → CountryController            (recibe CreateCountryRequest, lo valida)
  → RegisterCountryUseCase       (arma el command, llama Country.register(...))
  → CountryRepository            (interfaz del dominio)
  → CountryRepositoryAdapter     (implementación: usa el mapper + JpaRepository)
  → PostgreSQL
  ← CountryResponse              (vuelve hasta el controller como JSON)
```

## 5. Paso a paso recomendado

1. Crear los 3 archivos compartidos (`AggregateRoot`, `DomainEvent`, `ApplicationException`). Mientras no existan, los eventos y el agregado van a marcar error en el `import`.
2. Hacer **`countries` completa** (las 3 capas), compilar con `./mvnw clean compile` y probar con Postman. Esta tabla sirve de plantilla propia.
3. Seguir con las tablas **en el orden de las migraciones** (V1, V2, V3…), porque las tablas "hijas" referencian a las "padres". Las primeras ~26 son catálogos simples (pocas columnas, sin llaves foráneas) y salen rápido.
4. Después de cada tabla: compilar. Cada cierto número de tablas: levantar la app para que Hibernate valide el mapeo.

## 6. Errores típicos (leer antes de empezar)

1. **Usar las columnas reales de la tabla**, no `name`/`code`/`active` del ejemplo. El proyecto tiene `spring.jpa.hibernate.ddl-auto=validate`: Hibernate **no crea** las tablas (lo hace Flyway con los `.sql` de `db/migration`), solo **verifica** que la `@Entity` coincida exactamente. Si una columna se llama `name_country`, hay que poner `@Column(name = "name_country")`, o la app no arranca.
2. **Nombres de tabla con errores ortográficos se respetan tal cual**: `clinical_record_statusses`, `encounter_statusses`, `conversations_statuses`, etc.
3. **Llaves foráneas = guardar el ID**, no el objeto. En el dominio: `CountryId countryId`. En la entity: `UUID` con `@Column(name = "country_id")`. **No usar `@ManyToOne`** entre tablas distintas (en DDD un agregado no contiene a otro, solo lo referencia por su ID).
4. **`created_at NOT NULL DEFAULT NOW()`**: JPA manda `null` explícito y el default de la BD no se aplica → error al insertar. Se asigna en `register()` con `LocalDateTime.now()` (o `@CreationTimestamp` en la entity). `updated_at` se asigna en `update()`.
5. **Tipos**: `VARCHAR/TEXT`→`String`, `BOOLEAN`→`Boolean`, `INTEGER`→`Integer`, `DECIMAL(p,s)`→`BigDecimal` con `@Column(precision = p, scale = s)`, `DATE`→`LocalDate`, `TIMESTAMP`→`LocalDateTime`, `JSONB`→`String` con `@JdbcTypeCode(SqlTypes.JSON)`.
6. **Falta la dependencia de validación**: para usar `@Valid`/`@NotBlank` hay que agregar `spring-boot-starter-validation` al `pom.xml` de `infrastructure`.
7. **El dominio no importa nada** de `application` ni de `infrastructure`, y `application` no importa nada de `infrastructure`. Si ves un `import com.tarea.infrastructure…` en el dominio, está mal.

## 7. Datos del proyecto

- Maven multi-módulo: `domain`, `application`, `infrastructure`. Paquete base `com.tarea`.
- Java 21, Spring Boot 4.1.1, PostgreSQL, Flyway, Spring Data JPA.
- Las carpetas de los 52 bounded contexts ya están creadas. Nombres de paquete en singular, minúsculas y sin guiones bajos: `countries`→`country`, `state_regions`→`stateregion`, `city_municipalities`→`citymunicipality`, `chat_escalation_status_history`→`chatescalationstatushistory`… La clase va en PascalCase: `Country`, `StateRegion`, `CityMunicipality`…
- Orden de las tablas y sus llaves foráneas: ver los archivos `infrastructure/src/main/resources/db/migration/V1__…sql` a `V52__…sql`.
