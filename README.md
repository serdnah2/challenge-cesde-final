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

http://localhost:8086/swagger-ui/index.html

Errores en los logs

- Logs de la aplicación: Revisa los logs de la aplicación para identificar cualquier error durante la inicialización. Los problemas en la configuración de otros componentes pueden interferir con la configuración de Swagger.

Contribuir

Si deseas contribuir a este proyecto, por favor abre un Issue o envía un Pull Request con tus cambios.

Licencia

Este proyecto está licenciado bajo la Licencia MIT.
