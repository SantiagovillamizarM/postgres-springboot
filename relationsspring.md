# Uno a Muchos

## En la tabla hija colocar

```java
@ManyToOne
@JoinColumn(name = "test_id") //Nombre llave foranea
@JsonBackReference
Test tests; //Clase principal
```

🧱 `@ManyToOne`

  Esta anotación indica que existe una **relación muchos-a-uno** entre esta entidad (por ejemplo, `Pregunta`) y la entidad `Test`.

 🧠 Traducción:

  > Muchas preguntas (`this`) pueden estar asociadas a un solo test (`Test`).

------

🔗 `@JoinColumn(name = "test_id")`

  Esta anotación define la **columna de clave foránea** (foreign key) en la tabla actual que se usará para referenciar al `Test`.

  - `test_id` será la columna que apunta a la `id` del `Test`.
  - Si no la pones, JPA usa `tests_id` como nombre por convención.

🔄 `@JsonBackReference`

  Esto es parte de **Jackson (para JSON)**, no de JPA.

  Sirve para evitar la **serialización circular** cuando tienes una relación bidireccional.

📦 `Test tests;`

  Este es el campo de tipo `Test` (la clase principal), que representa la relación.

  - Debe tener sus `@Getter` y `@Setter`

  - Puedes acceder a `tests.getNombre()` o `tests.getId()` desde el objeto `Pregunta`.

## En la tabla padre

```java
@OneToMany(mappedBy = "tests",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JsonManagedReference
private Set<Test> tests = new HashSet<>();
```

🔁 `@OneToMany`

  Esta anotación indica que existe una **relación uno-a-muchos**. Es decir:

  > Un objeto de esta clase puede tener **muchos `Test` asociados**.
  >


🔗 `mappedBy = "tests"`

Esto indica que **la relación está mapeada en la clase `Test`**, en un atributo llamado `tests`.
 Es decir, esta clase **no es la dueña de la relación**, sino la clase `Test`.

🐢 `fetch = FetchType.LAZY`

Esto le dice a JPA que **no cargue los `Test` automáticamente** cuando consultes el objeto padre.

🔄 Se cargan **solo cuando los necesites** (`getTests()`).

✅ Es útil para optimizar rendimiento cuando tienes muchas relaciones.

🌊 `cascade = CascadeType.ALL`

Indica que cualquier operación realizada sobre el objeto padre se **propaga a los hijos** (`Test`).

✔️ Ejemplos:

- Si haces `.save(objetoPadre)` → también guarda los `Test` que contenga.
- Si haces `.delete(objetoPadre)` → también elimina todos sus `Test`.

🧠 `@JsonManagedReference`

Esto se usa para **evitar la recursión infinita** al convertir el objeto a JSON (como ya vimos).

- Esta parte es la **que se incluye** en el JSON serializado.
- El lado opuesto, en la clase `Test`, debería tener `@JsonBackReference`.

🧺 `private Set<Test> tests = new HashSet<>();`

Se está inicializando el conjunto de `Test` en memoria para evitar `NullPointerException`.
 Podrías usar también `List<Test>` si no necesitas eliminar duplicados.

> Si usa lombok se debe agregar las siguientes anotaciones al inicio de la clase

```java
@Getter
@Setter
@EqualsAndHashCode(exclude = {"tests"})
@ToString(exclude = {"tests"})
```
# Relaciones Muchos a Muchos

Se debe implementar una nueva clase que tenga la definición de las propiedades de clases que van a ser la llave compuesta

Para el ejemplo nos encontramos con la siguiente relacion Mucho a Muchos

![](https://i.ibb.co/2zLgT9P/image.png)

Se crea la clase con la siguiente estructura NombreTablaCompuestaId. Para el ejemplo la clase se llamara **TestQuestionId**

```java
package com.breakline.educate.educate_app.domain.entities.fkclasses;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class TestQuestionId implements Serializable{
    @Column(name = "test_id")
    private Long testId;
    @Column(name = "question_id")
    private Long questionId;
    
    public TestQuestionId() {
    }
    
}
```

Cree la clase que representara la tabla intermedia pra el caso practico TestQuestion

```java
package com.breakline.educate.educate_app.domain.entities;

import com.breakline.educate.educate_app.domain.entities.fkclasses.TestQuestionId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "test_questions")
@Entity
@JsonIgnoreProperties({"tests","questions"})
public class TestQuestion {
    @EmbeddedId
    private TestQuestionId Id;

    @ManyToOne
    @JoinColumn(name = "test_id",insertable = false,updatable = false)
    private Test tests;

    @ManyToOne
    @JoinColumn(name = "question_id",insertable = false,updatable = false)
    private Question questions;

    @Embedded
    Audit audit = new Audit();

    public TestQuestion() {
    }
      
}
```



Por ultimo en las entidades principales agregue las anotaciones OneToMany.

```java
package com.breakline.educate.educate_app.domain.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode(exclude = {"tests","testquestions"})	
@ToString(exclude = {"tests","testquestions"})
@Table(name = "test")
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="nametest",length = 50, nullable = false)
    @NotNull(message = "El nombre no puede ser nulo")
    String nametest;

    @Column(name="chapter_title",columnDefinition = "text", nullable = false)
    @NotNull(message = "El titulo del capitulo no puede ser vacio")
    String description;

    @Column(name = "date_start", columnDefinition = "DATE")
    LocalDate startAtDate;

    @Column(name = "date_end", columnDefinition = "DATE")
    LocalDate endAtDate;

    @Column(columnDefinition = "INTEGER")
    int duration;

    @Column(name="number_question",length = 7, nullable = false)
    @NotNull(message = "El numero de la pregunta no puede ser nulo")
    String numberQuestion;

    @OneToMany(mappedBy = "tests",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Test> tests = new HashSet<>();

    @OneToMany(mappedBy = "tests",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<TestQuestion> testquestions = new HashSet<>();

    @Embedded
    Audit audit = new Audit();
 
}
```



```java
package com.breakline.educate.educate_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"testquestions"})	
@ToString(exclude = {"testquestions"})
@Table(name = "questions")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(name="description",length = 80, nullable = false)
    @NotNull(message = "La descripcion de la pregunta no puede estar vacia")
    String description;

    @Column(name = "score", columnDefinition = "INTEGER")
    int score;

    @OneToMany(mappedBy = "questions",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<TestQuestion> testquestions = new HashSet<>();

    @Embedded
    Audit audit = new Audit();
}
```


