# Spring + Hibernate + MySQL 
Implentacion demostrativa de Spring, Hibernate y MySQL.

## Archivo "aplication.properties"

```
spring.datasource.driver.class=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/<dbname>

spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=<schema-option>
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.properties.hibernate.format_sql=true
spring.batch.job.enabled=false

server.error.include-message=always
```
* **dbname** es el nombre de una base datos existente (debe ser creada previamente)
* **username** y **password** son los valores del usuario registrado en su base de datos MySQL 
* **schema-option** puede ser *validate*, *update*, *create* y *create-drop* **(recomendado)**

### ¿Que significa cada "schema-option"?   
Los esquemas en SQL  se utilizan para organizar o agrupar los conjuntos de objetos de una base de datos. **Hibernate** nos da la opcion de asignar una forma de tratar a la base de datos segun la configuracion `hibernate.ddl-auto`

* `validate`: valida el "schema", sin realizar cambio a la base de datos.
* `update`: actualiza el "schema".
* `create`: crea el "schema", destruyendo los datos pre-existentes.
* `create-drop`: destruye el "schema" cuando la aplicacion se cierra.

### URL para realizar pruebas
Ingresamos en **POSTMAN**: `http://localhost:8080/api/student`
* **GET**: no hace falta agragar nada mas.
* **UPDATE**: agregar en el path el atributo a modificar (Ejemplo: `http://localhost:8080/api/student/1?name=Juan`) **Solo se puede modificar este atributo**
* **DELETE**: agregar en el path el ID del estudiante a eliminar (Ejemplo: `http://localhost:8080/api/student/1`)
* * **POST**: ingresar informacion de un estudiante en el `body`.

#### JSON de estudiante
```
{
    "name": "Carlos",
    "email": "carlos@gmail.com",
    "birthday": "2000-04-22",
    "age": 21
}
```

