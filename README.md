Proyecto Demo con Spring Boot y Swagger

Este proyecto es una aplicación de ejemplo construida con Spring Boot y `springdoc-openapi` para la generación de documentación API con Swagger.

Requisitos Previos

- Java 11 o superior
- Maven 3.6.3 o superior

Estructura del Proyecto

src
└── main
├── java
│   └── com
│       └── example
│           └── demo
│               ├── DemoApplication.java
│               └── ExampleController.java
└── resources
└── application.properties
pom.xml

Configuración de Dependencias

Asegúrate de que tu `pom.xml` incluye las siguientes dependencias:

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.10</version> <!-- Usa la versión más reciente compatible -->
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

Configuración de la Aplicación

En tu archivo `application.properties`, añade las siguientes configuraciones:

server.port=8080
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

Código Fuente

Clase Principal

Archivo: `DemoApplication.java`

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

Controlador REST

Archivo: `ExampleController.java`

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExampleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}

Archivo de Propiedades

Archivo: `application.properties`

Este archivo debe encontrarse en la carpeta `src/main/resources`:

server.port=8080
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

Compilación y Ejecución

Para compilar y ejecutar la aplicación, sigue estos pasos:

1. Limpiar y Compilar

Ejecuta el siguiente comando para limpiar y compilar el proyecto:

mvn clean install

2. Ejecutar la Aplicación

Ejecuta la aplicación con el siguiente comando:

mvn spring-boot:run

3. Acceder a Swagger UI

Una vez que la aplicación esté en funcionamiento, puedes acceder a la interfaz de Swagger UI en:

http://localhost:8080/swagger-ui/index.html

Verificación Adicional

Si la URL anterior no funciona, intenta con la siguiente:

http://localhost:8080/swagger-ui.html

Y verifica la URL de OpenAPI directamente accediendo a:

http://localhost:8080/v3/api-docs

Deberías ver un documento JSON con la especificación OpenAPI de tu API.

Problemas Comunes

No se encuentra `swagger-ui.html`

- Verifica dependencias: Asegúrate de que las dependencias en `pom.xml` están correctamente configuradas.
- Propiedades correctas: Verifica que tu archivo `application.properties` tenga las configuraciones necesarias.

Errores en los logs

- Logs de la aplicación: Revisa los logs de la aplicación para identificar cualquier error durante la inicialización. Los problemas en la configuración de otros componentes pueden interferir con la configuración de Swagger.

Contribuir

Si deseas contribuir a este proyecto, por favor abre un Issue o envía un Pull Request con tus cambios.

Licencia

Este proyecto está licenciado bajo la Licencia MIT.