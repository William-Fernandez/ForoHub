# 💬 Foro Hub API

![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON-Web-Tokens)

**Foro Hub** es una API RESTful desarrollada en Java con el framework Spring Boot. Permite a los usuarios interactuar con un foro de tópicos, ofreciendo funcionalidades completas de **CRUD** (Crear, Leer, Actualizar, Eliminar) con un robusto sistema de autenticación y autorización basado en **JWT**.

---

## 🚀 Tecnologías Utilizadas

* **Lenguaje:** Java 21
* **Framework:** Spring Boot
* **Gestión de Base de Datos:**
    * **Base de datos:** MySQL
    * **Persistencia:** Spring Data JPA / Hibernate
    * **Migraciones:** Flyway
* **Seguridad:** Spring Security y JWT (JSON Web Tokens)
* **Construcción:** Maven

---

## 📦 Funcionalidades Principales

* **Autenticación de Usuarios:** Acceso protegido a través de un token JWT.
* **Gestión de Tópicos (CRUD):**
    1.  **Crear:** Registrar nuevos tópicos con validaciones de datos.
    2.  **Listar:** Ver todos los tópicos existentes, con soporte para paginación.
    3.  **Detallar:** Consultar la información de un tópico específico por su ID.
    4.  **Actualizar:** Modificar los datos de un tópico existente.
    5.  **Eliminar:** Borrar un tópico de la base de datos.
* **Reglas de Negocio:**
    * Los campos son obligatorios y se validan en la entrada.
    * Se evita la creación de tópicos duplicados (mismo título y mensaje).

---

## ⚙️ Configuración del Proyecto

### 1. Clonar el Repositorio

```bash
git clone [https://github.com/William-Fernandez/foro-hub.git](https://github.com/William-Fernandez/foro-hub.git)
cd foro-hub
````

### 2\. Configurar la Base de Datos

* Asegúrate de tener MySQL instalado y en ejecución.
* Crea la base de datos `foro_hub_db` y las tablas necesarias (`topicos` y `usuarios`). Puedes usar los scripts de migración que se encuentran en el proyecto o crearlas manualmente.

### 3\. Variables de Entorno

Para evitar exponer datos sensibles, es crucial configurar las siguientes variables de entorno en tu sistema:

```bash
export FORO_HUB_DB_URL="jdbc:mysql://localhost:3306/foro_hub_db?useSSL=false&serverTimezone=UTC"
export FORO_HUB_DB_USER="root"
export FORO_HUB_DB_PASS="tu_contraseña_mysql"
export FORO_HUB_JWT_SECRET="un_secreto_largo_y_seguro"
```

### 4\. Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

-----

## 🔑 Endpoints de la API

La API expone los siguientes endpoints, que pueden ser probados con herramientas como Postman o Insomnia.

### Autenticación

| Método | URL | Descripción |
| :--- | :--- | :--- |
| `POST` | `/login` | Autentica al usuario y retorna un token JWT. |

### Tópicos

| Método | URL | Descripción |
| :--- | :--- | :--- |
| `POST` | `/api/topicos` | Crea un nuevo tópico. |
| `GET` | `/api/topicos` | Lista todos los tópicos. Soporta paginación. |
| `GET` | `/api/topicos/{id}` | Obtiene un tópico específico por su ID. |
| `PUT` | `/api/topicos/{id}` | Actualiza un tópico existente. |
| `DELETE` | `/api/topicos/{id}` | Elimina un tópico. |

> **Nota:** Todos los endpoints de tópicos requieren un **header `Authorization`** con el token JWT: `Bearer <tu_token>`.

-----

## 🤝 Autor

* **William Fernandez** - [GitHub](https://www.google.com/search?q=https://github.com/William-Fernandez)

-----

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.