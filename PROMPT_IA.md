# Contexto para ayudarme con mi tarea de DDD + Arquitectura Hexagonal (Spring Boot)

Actúa como tutor experto en Java, Spring Boot, DDD y arquitectura hexagonal. **Quiero aprender y escribir el código yo mismo**: explícame, revisa lo que hago y corrige errores. Solo genera código completo si te lo pido explícitamente. Responde en español.

## 1. La tarea

Mi profesor pidió: *"Construir la capa de dominio, aplicación e infraestructura de cada bounded context de la base de datos"*, donde **bounded context = tabla**. Él nos dio un proyecto de ejemplo con UNA tabla (`country`) ya hecha, y yo debo replicar ese mismo patrón para cada tabla de mi base de datos (52 tablas).

## 2. Mi proyecto

- Maven multi-módulo: `domain`, `application`, `infrastructure`. Paquete base: `com.tarea`.
- Java 21, Spring Boot 4.1.1 (parent `spring-boot-starter-parent`), PostgreSQL, Flyway, Spring Data JPA.
- Dependencias entre módulos: `infrastructure → application → domain`. `domain` es Java puro (sin Spring, sin JPA).
- Clase principal: `infrastructure/src/main/java/com/tarea/infrastructure/TareaApplication.java`.
- `application.properties`:
  - `spring.jpa.hibernate.ddl-auto=validate` → **Hibernate NO crea tablas, solo valida** que cada `@Entity` coincida EXACTAMENTE con la tabla (nombre de tabla, nombre de columnas y tipos).
  - `spring.flyway.enabled=true` → las tablas las crean los scripts `infrastructure/src/main/resources/db/migration/V1__...sql` a `V52__...sql` (YA EXISTEN, no hay que crearlos).
- Todas las tablas tienen `id UUID PRIMARY KEY DEFAULT gen_random_uuid()`.

## 3. Estructura de archivos por tabla (≈24 archivos)

Ejemplo para la tabla `countries` (bounded context `country`). Para otra tabla se cambia `country/Country` por el nombre correspondiente:

```
domain/src/main/java/com/tarea/domain/
├── common/event/DomainEvent.java              (compartido, se crea una sola vez)
├── common/model/AggregateRoot.java            (compartido, se crea una sola vez)
└── country/
    ├── model/aggregate/Country.java           agregado: constructor privado, register(), restore(), update(), getters estilo name()
    ├── model/valueobject/CountryId.java       record con UUID value + generate()
    ├── event/CountryRegisteredEvent.java      record implements DomainEvent
    ├── event/CountryUpdatedEvent.java
    ├── event/CountryDeletedEvent.java
    ├── exception/CountryNotFoundException.java
    └── port/repository/CountryRepository.java puerto de salida (interface)

application/src/main/java/com/tarea/application/
├── common/exception/ApplicationException.java (compartido)
└── country/
    ├── command/RegisterCountryCommand.java    record
    ├── command/UpdateCountryCommand.java      record (incluye CountryId)
    ├── dto/CountryResponse.java               record (UUID id + campos)
    ├── exception/CountryNotFoundApplicationException.java
    └── usecase/RegisterCountryUseCase.java, GetCountryByIdUseCase.java,
        ListCountryUseCase.java, UpdateCountryUseCase.java, DeleteCountryUseCase.java
        (clases Java normales, SIN anotaciones de Spring; reciben el CountryRepository por constructor)

infrastructure/src/main/java/com/tarea/infrastructure/
├── common/exception/GlobalExceptionHandler.java (compartido: @RestControllerAdvice, NotFound → 404)
└── country/
    ├── adapters/in/rest/controllers/CountryController.java   @RestController /api/countries (POST, GET, GET /{id}, PUT /{id}, DELETE /{id})
    ├── adapters/in/rest/dtos/CreateCountryRequest.java       record con @NotBlank, @Size...
    ├── adapters/in/rest/dtos/UpdateCountryRequest.java
    ├── adapters/out/persistence/entity/CountryJpaEntity.java @Entity @Table(name="countries")
    ├── adapters/out/persistence/repositories/CountryJpaRepository.java     extends JpaRepository<CountryJpaEntity, UUID>
    ├── adapters/out/persistence/repositories/CountryRepositoryAdapter.java implements CountryRepository (dominio)
    ├── adapters/out/persistence/mappers/CountryPersistenceMapper.java      toJpa() / toDomain()
    └── config/CountryBeansConfig.java         @Configuration con @Bean del mapper, del adapter y de los 5 casos de uso
```

## 4. Código plantilla del profesor (resumido)

```java
// domain/common/model/AggregateRoot.java
public abstract class AggregateRoot {
    private final List<DomainEvent> domainEvents = new ArrayList<>();
    protected final void recordEvent(DomainEvent event) { domainEvents.add(Objects.requireNonNull(event)); }
    public final List<DomainEvent> domainEvents() { return List.copyOf(domainEvents); }
    public final void clearDomainEvents() { domainEvents.clear(); }
}

// domain/common/event/DomainEvent.java
public interface DomainEvent { LocalDateTime occurredOn(); }

// domain/country/model/valueobject/CountryId.java
public record CountryId(UUID value) {
    public CountryId { Objects.requireNonNull(value, "CountryId value must not be null"); }
    public static CountryId generate() { return new CountryId(UUID.randomUUID()); }
}

// domain/country/model/aggregate/Country.java
public class Country extends AggregateRoot {
    private final CountryId id;
    private String name;
    private String code;
    private boolean active;

    private Country(CountryId id, String name, String code, boolean active) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }
    public static Country register(String name, String code) {          // crear nuevo
        CountryId id = CountryId.generate();
        Country country = new Country(id, name, code, true);
        country.recordEvent(new CountryRegisteredEvent(id, LocalDateTime.now()));
        return country;
    }
    public static Country restore(CountryId id, String name, String code, boolean active) { // reconstruir desde BD
        return new Country(id, name, code, active);
    }
    public void update(String name, String code) {
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        recordEvent(new CountryUpdatedEvent(id, this.name, this.code, LocalDateTime.now()));
    }
    public CountryId id() { return id; }
    public String name() { return name; }
    public String code() { return code; }
    public boolean active() { return active; }
}

// domain/country/event/CountryRegisteredEvent.java  (Updated lleva además los campos; Deleted igual que Registered)
public record CountryRegisteredEvent(CountryId id, LocalDateTime occurredOn) implements DomainEvent {
    public CountryRegisteredEvent { Objects.requireNonNull(id); Objects.requireNonNull(occurredOn); }
}

// domain/country/port/repository/CountryRepository.java
public interface CountryRepository {
    Country save(Country country);
    Optional<Country> findById(CountryId id);
    List<Country> findAll();
    boolean existsByCode(String code);
    void delete(Country country);
}

// application/country/usecase/UpdateCountryUseCase.java  (los demás siguen el mismo estilo)
public class UpdateCountryUseCase {
    private final CountryRepository countryRepository;
    public UpdateCountryUseCase(CountryRepository countryRepository) { this.countryRepository = countryRepository; }
    public CountryResponse execute(UpdateCountryCommand command) {
        var country = countryRepository.findById(command.id())
                .orElseThrow(() -> new CountryNotFoundApplicationException(command.id().value().toString()));
        country.update(command.name(), command.code());
        var updated = countryRepository.save(country);
        return new CountryResponse(updated.id().value(), updated.name(), updated.code());
    }
}
// DeleteCountryUseCase: busca, llama countryRepository.delete(country) y retorna new CountryDeletedEvent(id, LocalDateTime.now())

// infrastructure/country/adapters/out/persistence/mappers/CountryPersistenceMapper.java
public class CountryPersistenceMapper {
    public CountryJpaEntity toJpa(Country d) {
        if (d == null) return null;
        CountryJpaEntity jpa = new CountryJpaEntity();
        jpa.setId(d.id().value()); jpa.setName(d.name()); jpa.setCode(d.code()); jpa.setActive(d.active());
        return jpa;
    }
    public Country toDomain(CountryJpaEntity jpa) {
        if (jpa == null) return null;
        return Country.restore(new CountryId(jpa.getId()), jpa.getName(), jpa.getCode(), jpa.isActive());
    }
}

// infrastructure/country/adapters/out/persistence/repositories/CountryRepositoryAdapter.java
public class CountryRepositoryAdapter implements CountryRepository {
    private final CountryJpaRepository countryJpaRepository;
    private final CountryPersistenceMapper mapper;
    // constructor...
    public Country save(Country c) { return mapper.toDomain(countryJpaRepository.save(mapper.toJpa(c))); }
    public Optional<Country> findById(CountryId id) { return countryJpaRepository.findById(id.value()).map(mapper::toDomain); }
    public List<Country> findAll() { return countryJpaRepository.findAll().stream().map(mapper::toDomain).toList(); }
    public boolean existsByCode(String code) { return countryJpaRepository.existsByCode(code); }
    public void delete(Country c) { countryJpaRepository.deleteById(c.id().value()); }
}

// infrastructure/country/config/CountryBeansConfig.java
@Configuration
public class CountryBeansConfig {
    @Bean public CountryPersistenceMapper countryPersistenceMapper() { return new CountryPersistenceMapper(); }
    @Bean public CountryRepository countryRepository(CountryJpaRepository r, CountryPersistenceMapper m) { return new CountryRepositoryAdapter(r, m); }
    @Bean public RegisterCountryUseCase registerCountryUseCase(CountryRepository r) { return new RegisterCountryUseCase(r); }
    // ... igual para GetById, List, Update y Delete
}

// infrastructure/country/adapters/in/rest/controllers/CountryController.java
@RestController
@RequestMapping("/api/countries")
public class CountryController {
    // recibe los 5 casos de uso por constructor
    @PostMapping public ResponseEntity<CountryResponse> create(@Valid @RequestBody CreateCountryRequest request) {
        var command = new RegisterCountryCommand(request.name(), request.code());
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUseCase.execute(command));
    }
    @GetMapping public ResponseEntity<List<CountryResponse>> findAll() { return ResponseEntity.ok(listUseCase.execute()); }
    @GetMapping("/{id}") public ResponseEntity<CountryResponse> findById(@PathVariable UUID id) { return ResponseEntity.ok(getByIdUseCase.execute(new CountryId(id))); }
    @PutMapping("/{id}") public ResponseEntity<CountryResponse> update(@PathVariable UUID id, @Valid @RequestBody UpdateCountryRequest request) { ... }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable UUID id) { deleteUseCase.execute(new CountryId(id)); return ResponseEntity.noContent().build(); }
}
```

## 5. Reglas que debes respetar al ayudarme

1. **El agregado y la JpaEntity deben tener los campos REALES de la tabla** (los del script SQL que te pase), no `name`/`code`/`active` del ejemplo. Respeta los nombres exactos de tabla y columna con `@Table(name=...)` y `@Column(name=...)`. Ojo: algunas tablas tienen nombres "raros" que hay que respetar tal cual (ej. `clinical_record_statusses`, `encounter_statusses`, `conversations_statuses`).
2. **Llaves foráneas = referencia por ID**, no por objeto. En el dominio un campo FK es el `XId` del otro agregado (ej. `StateRegion` tiene `CountryId countryId`); en la JpaEntity es un `UUID` con `@Column(name="country_id")`. **No usar `@ManyToOne`** entre bounded contexts.
3. Mapeo de tipos SQL → Java: `UUID`→`UUID`, `VARCHAR/TEXT`→`String`, `BOOLEAN`→`Boolean/boolean`, `INTEGER`→`Integer`, `DECIMAL(p,s)`→`BigDecimal` con `@Column(precision=p, scale=s)`, `DATE`→`LocalDate`, `TIMESTAMP`→`LocalDateTime`, `JSONB`→`String` con `@JdbcTypeCode(SqlTypes.JSON)` (si no, `validate` falla).
4. Columnas `created_at TIMESTAMP NOT NULL DEFAULT NOW()`: JPA inserta `null` explícito y el DEFAULT de la BD no se aplica → error. Hay que asignarla en el dominio (`register()` pone `LocalDateTime.now()`) o usar `@CreationTimestamp` en la entity. `updated_at` se asigna en `update()`.
5. El dominio NO usa Spring, JPA ni Lombok. Los casos de uso NO llevan `@Service`; se registran como `@Bean` en `XBeansConfig`.
6. El método extra del repositorio (`existsByCode` en el ejemplo) solo se agrega si la tabla tiene una columna `UNIQUE` que tenga sentido validar.
7. Las validaciones de los Request (`@NotBlank`, `@Size(max=...)`, `@NotNull`) deben reflejar el `NOT NULL` y el largo del `VARCHAR` del SQL.

## 6. Las 52 tablas (orden de las migraciones, padres primero)

**Las carpetas de los 52 bounded contexts YA ESTÁN CREADAS** (vacías) en los 3 módulos, con la estructura de la sección 3, más `domain/common/event`, `domain/common/model`, `application/common/exception` e `infrastructure/common/exception`. Usa exactamente estos nombres de paquete (minúsculas, singular, sin guiones bajos) y de clase:

| V | Tabla | Paquete | Clase del agregado | FK hacia |
|---|---|---|---|---|
| 1 | countries | country | Country | – |
| 2 | state_regions | stateregion | StateRegion | countries |
| 3 | city_municipalities | citymunicipality | CityMunicipality | state_regions |
| 4 | document_types | documenttype | DocumentType | – |
| 5 | genders | gender | Gender | – |
| 6 | relationship_types | relationshiptype | RelationshipType | – |
| 7 | professional_types | professionaltype | ProfessionalType | – |
| 8 | studies | study | Study | – |
| 9 | clinical_record_statusses | clinicalrecordstatus | ClinicalRecordStatus | – |
| 10 | encounter_types | encountertype | EncounterType | – |
| 11 | encounter_modalities | encountermodality | EncounterModality | – |
| 12 | encounter_statusses | encounterstatus | EncounterStatus | – |
| 13 | risk_levels | risklevel | RiskLevel | – |
| 14 | treatment_statusses | treatmentstatus | TreatmentStatus | – |
| 15 | treatment_goal_statusses | treatmentgoalstatus | TreatmentGoalStatus | – |
| 16 | medication_routes | medicationroute | MedicationRoute | – |
| 17 | assessment_types | assessmenttype | AssessmentType | – |
| 18 | consent_types | consenttype | ConsentType | – |
| 19 | diagnostic_systems | diagnosticsystem | DiagnosticSystem | – |
| 20 | sender_types | sendertype | SenderType | – |
| 21 | priorities | priority | Priority | – |
| 22 | conversations_statuses | conversationstatus | ConversationStatus | – |
| 23 | message_types | messagetype | MessageType | – |
| 24 | ai_runs_statuses | airunstatus | AiRunStatus | – |
| 25 | escalations_statuses | escalationstatus | EscalationStatus | – |
| 26 | provider_models_ai | providermodelai | ProviderModelAi | – |
| 27 | ai_models | aimodel | AiModel | provider_models_ai |
| 28 | professionals | professional | Professional | city_municipalities, document_types, professional_types |
| 29 | professional_studies | professionalstudy | ProfessionalStudy | countries, professionals, studies |
| 30 | patients | patient | Patient | city_municipalities, document_types, genders, professionals |
| 31 | patient_allergies | patientallergy | PatientAllergy | patients |
| 32 | contacts | contact | Contact | city_municipalities, professionals |
| 33 | phone_contacts | phonecontact | PhoneContact | contacts |
| 34 | email_contacts | emailcontact | EmailContact | contacts |
| 35 | patient_contacts | patientcontact | PatientContact | contacts, patients, relationship_types |
| 36 | clinical_records | clinicalrecord | ClinicalRecord | clinical_record_statusses, patients, professionals |
| 37 | encounters | encounter | Encounter | clinical_records, encounter_modalities, encounter_statusses, encounter_types, professionals |
| 38 | clinical_notes | clinicalnote | ClinicalNote | encounters, professionals |
| 39 | mental_status_exams | mentalstatusexam | MentalStatusExam | encounters, professionals |
| 40 | risk_assessments | riskassessment | RiskAssessment | encounters, professionals, risk_levels |
| 41 | treatment_plans | treatmentplan | TreatmentPlan | encounters, professionals, treatment_statusses |
| 42 | treatment_goals | treatmentgoal | TreatmentGoal | treatment_goal_statusses, treatment_plans |
| 43 | chat_conversations | chatconversation | ChatConversation | conversations_statuses, priorities |
| 44 | chat_participants | chatparticipant | ChatParticipant | chat_conversations, patients, professionals, sender_types |
| 45 | chat_messages | chatmessage | ChatMessage | chat_conversations, chat_participants, message_types |
| 46 | chat_conversation_ai_settings | chatconversationaisetting | ChatConversationAiSetting | ai_models, chat_conversations |
| 47 | chat_ai_runs | chatairun | ChatAiRun | ai_models, ai_runs_statuses, chat_conversations, chat_messages |
| 48 | chat_ai_run_metrics | chatairunmetric | ChatAiRunMetric | chat_ai_runs |
| 49 | chat_ai_run_errors | chatairunerror | ChatAiRunError | chat_ai_runs |
| 50 | chat_escalations | chatescalation | ChatEscalation | chat_conversations, escalations_statuses |
| 51 | chat_escalation_assignments | chatescalationassignment | ChatEscalationAssignment | chat_escalations, professionals |
| 52 | chat_escalation_status_history | chatescalationstatushistory | ChatEscalationStatusHistory | chat_escalations, escalations_statuses |

Ejemplo de ruta completa: `domain/src/main/java/com/tarea/domain/stateregion/model/aggregate/StateRegion.java` con `package com.tarea.domain.stateregion.model.aggregate;`.

## 7. Cómo vamos a trabajar

- Vamos **una tabla a la vez**, empezando por `countries`. Antes de cada tabla te pego su script SQL.
- Si me falta información (columnas, tipos), **pídemela en vez de inventarla**.
- Cuando te muestre mi código, revisa: que respete la plantilla, que la entity coincida con el SQL (por el `validate`), que las capas no se mezclen (el dominio no importa nada de application ni de infrastructure; application no importa nada de infrastructure) y que compile.
- Para comprobar: `./mvnw clean compile` y luego levantar la app (con PostgreSQL corriendo) para que Flyway + `validate` confirmen el mapeo.

Confírmame que entendiste el contexto con un resumen corto y espera a que te pase la primera tabla.
