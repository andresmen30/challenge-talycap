# challenge-talycap

Talycap project - Api Rest

La implementación del proyecto se llevo acabo con Java 17, junto con el framework Sprint boot, Maven y se utilizo la base de datos H2, para tener mas
legibilidad
al quemar los datos, sin embargo solo se encontrará un registro que es el que se propuso para el ejercicio.

## Tecnologias

### Java 17

### Spring Boot

### Spring data

### JUnit

### Mockito

### Tomcat

### Base de datos H2

### Intellij

### Mapstruct

### OpenApi - Swagger

### Consumo Servicio /challenge-talycap

```
http://localhost:8090/challenge/api
```

### Documentación Swagger

```
http://localhost:8090/challenge/api/client?identification&type_doc
```

### Documentación Swagger json

```
http://localhost:8090/challenge/api/api-docs
```

### Base de datos

```
http://localhost:8090/challenge/api/h2-console
```

## Endpoints

### GET /client?identification?type_doc

obtiene el cliente por identificación y tipo de documento

```
http://localhost:8090/challenge/api/client?identification&type_doc
```

### GET /hola

obtiene un mensaje con el alias del desarrollador

```
http://localhost:8090/challenge/api/hola
```

### GET /factorial/{number}

obtiene el factorial de el número enviado

```
http://localhost:8090/challenge/api/factorial/5
```

## Compilación del proyecto

##### Clonar del repositorio

```
git clone https://github.com/andresmen30/challenge-talycap.git
```

##### Compilar

Ubíquese en la ruta /challenge-talycap

```
mvn clean install
```

##### Desplegar

Ubíquese en la ruta /challenge-talycap/target y ejecute:

```
java -jar challenge-talycap-0.0.1-SNAPSHOT.jar
```













