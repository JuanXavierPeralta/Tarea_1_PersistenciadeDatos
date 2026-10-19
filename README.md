# Sistema de Gestión de Reservas — LATAM Airlines

Proyecto académico desarrollado para la asignatura de **Persistencia de Datos** de la Universidad Politécnica Salesiana.

## Descripción

Aplicación de escritorio para gestionar reservas de vuelos, utilizando Java y el mapeo objeto-relacional (ORM) mediante Hibernate, con PostgreSQL como base de datos.

## Tecnologías utilizadas

- Java (JDK 27)
- Hibernate ORM / JPA
- PostgreSQL
- Java Swing
- Apache NetBeans
- Maven

## Funcionalidades

El sistema permite realizar las operaciones CRUD:

- **Crear:** registrar nuevas reservas de vuelos.
- **Consultar:** buscar reservas por ID y visualizar todos los registros.
- **Actualizar:** modificar origen, destino y número de pasajeros.
- **Eliminar:** borrar reservas mediante su identificador, previa confirmación.

## Estructura del proyecto

- `Main.java`: inicia la aplicación.
- `views.java`: interfaz gráfica del sistema.
- `Reserva.java`: entidad que representa las reservas.
- `ReservaDAO.java`: gestiona las operaciones CRUD.
- `persistence.xml`: configuración de conexión con PostgreSQL.

## Base de datos

El sistema utiliza PostgreSQL con la base de datos `bd_LatamAirlines` y la tabla `tb_reserva`.

Para ejecutarlo, es necesario configurar las credenciales locales en `persistence.xml`.

## Propósito

Demostrar la implementación de operaciones CRUD mediante programación orientada a objetos y herramientas ORM, facilitando la interacción entre una aplicación Java y una base de datos relacional.

---

**Universidad Politécnica Salesiana — Persistencia de Datos**
