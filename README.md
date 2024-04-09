# Temporizador de Tareas
Una aplicación simple que te permite gestionar tus tiempos de tareas utilizando Room para el almacenamiento local. 
Puedes guardar, editar y eliminar tiempos, y utilizar un temporizador para medir el tiempo de tus tareas.
## Capturas de Pantalla
[room.webm](https://github.com/Yan1710/RoomCronoApp/assets/104707819/55b75132-3f2e-4031-878b-a698aa5035d0)

## Características Principales
+ Temporizador: Utiliza un temporizador para medir el tiempo de tus tareas.
+ Room: Utiliza Room para almacenar los tiempos de las tareas localmente en la base de datos.
+ Patrón de Repositorio y ViewModel: Utiliza el patrón de diseño Repositorio y ViewModel para separar la lógica de negocio de la interfaz de usuario y gestionar los datos de forma eficiente.

## Componentes Principales
### Temporizador
Utiliza un temporizador en la aplicación para medir el tiempo de tus tareas. Puedes iniciar, pausar y reiniciar el temporizador según sea necesario.

### Room
Utiliza Room como una capa de abstracción sobre SQLite para gestionar los tiempos de las tareas localmente en la base de datos. Define entidades, DAOs y una base de datos para interactuar con la base de datos.

### Patrón de Repositorio y ViewModel
Utiliza el patrón de diseño Repositorio para abstraer la fuente de datos y el patrón de diseño ViewModel para gestionar la UI y los datos relacionados con la UI de forma eficiente.
