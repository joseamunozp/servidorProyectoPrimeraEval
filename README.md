# Portfolio Application

Esta es una aplicación Astro que consume una API REST para gestionar proyectos, desarrolladores y tecnologías.

## Características

- Visualizar una lista de proyectos.
- Crear, actualizar y eliminar proyectos.
- Administrar tecnologías asociadas a proyectos.
- Administrar desarrolladores y sus asociaciones con proyectos.

## Requisitos previos

Asegúrate de tener instalados los siguientes programas:

- [Node.js](https://nodejs.org/) (versión 16 o superior).
- [npm](https://www.npmjs.com/) o [yarn](https://yarnpkg.com/).
- Un servidor que ejecute la API REST (puedes usar Spring Boot como backend).

## Instalación

bash
npm install
Configura la URL base de la API REST. En el archivo src/services/api.js, asegúrate de que la constante API_BASE_URL apunte a tu servidor:

const API_BASE_URL = 'http://localhost:8080/api/v1';

Scripts disponibles
npm start: Inicia el servidor de desarrollo.
npm run build: Genera una versión optimizada del proyecto para producción.
npm test: Ejecuta las pruebas unitarias del proyecto.
Estructura del proyecto
plaintext
Copiar código
src/
├── components/ # Componentes reutilizables como ProjectCard
├── pages/ # Vistas principales como ProjectsPage y AboutMe
├── services/ # Comunicación con la API REST
├── styles/ # Archivos CSS
├── App.jsx # Punto de entrada principal
├── index.jsx # Renderizado inicial de la aplicación
Endpoints de la API

## Endpoints

A continuación, algunos de los endpoints utilizados por la aplicación:

Proyectos

GET /api/v1/projects: Obtener todos los proyectos.
POST /api/v1/projects: Crear un proyecto.
DELETE /api/v1/projects/{id}: Eliminar un proyecto.
PUT /api/v1/projects/{id}: Actualizar un proyecto.
Tecnologías

GET /api/v1/technologies: Obtener todas las tecnologías.
POST /api/v1/technologies: Crear una tecnología.
DELETE /api/v1/technologies/{id}: Eliminar una tecnología.
Desarrolladores

GET /api/v1/developers: Obtener todos los desarrolladores.
POST /api/v1/developers: Crear un desarrollador.
DELETE /api/v1/developers/{id}: Eliminar un desarrollador.
Personalización
Modifica los estilos en la carpeta src/styles/.
Ajusta los componentes según sea necesario en src/components/.
Contribuciones
¡Las contribuciones son bienvenidas! Por favor, abre un issue o envía un pull request para mejorar el proyecto.

Aquí tienes un conjunto de rutas para probar los endpoints de tu API. Estas se corresponden con las funcionalidades más comunes en un sistema que gestiona proyectos, tecnologías y desarrolladores. Puedes utilizar herramientas como Postman o curl para realizar las pruebas.

Endpoints para Proyectos
Obtener todos los proyectos
GET http://localhost:8080/api/v1/projects

Crear un proyecto
POST http://localhost:8080/api/v1/projects
Body (JSON):

json
Copiar código
{
"projectName": "Nuevo Proyecto",
"description": "Descripción del proyecto",
"startDate": "2024-12-01T00:00:00",
"endDate": "2024-12-31T00:00:00",
"repositoryUrl": "https://github.com/example",
"demoUrl": "https://demo.example.com",
"picture": "https://example.com/image.jpg",
"status": { "statusId": 1 },
"technologies": [
{ "techId": 1 }
],
"developers": [
{ "devId": 1 }
]
}
Actualizar un proyecto
PUT http://localhost:8080/api/v1/projects/{id}
Body (JSON):

json
{
"projectName": "Proyecto Actualizado",
"description": "Descripción actualizada",
"startDate": "2024-12-01T00:00:00",
"endDate": "2025-01-01T00:00:00",
"repositoryUrl": "https://github.com/example-updated",
"demoUrl": "https://demo.example-updated.com",
"picture": "https://example.com/image-updated.jpg",
"status": { "statusId": 2 },
"technologies": [
{ "techId": 2 }
],
"developers": [
{ "devId": 2 }
]
}
Eliminar un proyecto
DELETE http://localhost:8080/api/v1/projects/{id}

Endpoints para Tecnologías
Obtener todas las tecnologías
GET http://localhost:8080/api/v1/technologies

Crear una tecnología
POST http://localhost:8080/api/v1/technologies
Body (JSON):

json
{
"techName": "JavaScript"
}
Eliminar una tecnología
DELETE http://localhost:8080/api/v1/technologies/{id}

Endpoints para Desarrolladores
Obtener todos los desarrolladores
GET http://localhost:8080/api/v1/developers

Crear un desarrollador
POST http://localhost:8080/api/v1/developers
Body (JSON):

json
{
"devName": "John",
"devSurname": "Doe",
"email": "john.doe@example.com",
"linkedinUrl": "https://linkedin.com/in/johndoe",
"githubUrl": "https://github.com/johndoe"
}
Eliminar un desarrollador
DELETE http://localhost:8080/api/v1/developers/{id}

## Notas:

Asegúrate de que tu API esté en ejecución: Antes de probar los endpoints, verifica que el servidor backend esté corriendo correctamente.
Datos iniciales: Si tu base de datos no tiene datos iniciales, es posible que debas crear estados, tecnologías y desarrolladores antes de crear un proyecto.
Errores comunes: Si obtienes errores de relación, verifica que los IDs de tecnologías, desarrolladores o estados existan en la base de datos.
¡Listo para probar la API! 🚀
