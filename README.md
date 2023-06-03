# Challenge ONE | Back End | Foro Alura
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![](https://raw.githubusercontent.com/Agathion-JD/Assets/f7d34ed465ffd32a4a6a6f66641d450ec343fead/logo-alura.svg)

Este proyecto es parte de los desafíos o challenges del programa Oracle Next Education. En esta ocasión, se trata de una API REST creada con Spring Boot que proporciona las funcionalidades básicas de un foro, centrándose principalmente en los tópicos.

### Funcionalidades principales:

-   Creación de tópicos: Permite a los usuarios crear nuevos tópicos proporcionando un título, un mensaje y asociándolos a un curso y autor existente.
-   Obtención de tópicos: Los usuarios pueden obtener una lista de todos los tópicos disponibles, incluyendo información relevante como el título, el mensaje, la fecha de creación, el estado, el autor y el curso asociado.
-   Actualización de tópicos: Permite a los usuarios actualizar el contenido de un tópico existente, incluyendo el título y el mensaje.
-   Cambio de estado de tópicos: Los usuarios pueden cambiar el estado de un tópico, marcándolo como activo, cerrado o eliminado.
-   Eliminación de tópicos: Permite a los usuarios eliminar un tópico existente.

Además de las funcionalidades relacionadas con los tópicos, la API también incluye endpoints para gestionar usuarios, cursos y respuestas.

La API utiliza Spring Boot, un framework de desarrollo de aplicaciones Java, para facilitar la creación de la API REST. Se integra con una base de datos relacional, que cuenta con las siguientes tablas:

-   "usuarios": Almacena la información de los usuarios, como el nombre, el email y la contraseña.
-   "respuestas": Almacena las respuestas a los tópicos, incluyendo el mensaje, la fecha de creación, el autor y si es una solución.
-   "cursos": Almacena la información de los cursos, como el nombre y la categoría.
-   "topicos": Almacena la información de los tópicos, incluyendo el título, el mensaje, la fecha de creación, el estado, el autor y el curso asociado. También tiene relaciones con las tablas de usuarios y cursos.

Este proyecto tiene como objetivo proporcionar una base sólida para desarrollar un sistema de gestión de foros más completo, permitiendo a los usuarios interactuar y compartir conocimientos en un entorno educativo.

### Herramientas utilizadas

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)

### Funcionamiento 

![](https://raw.githubusercontent.com/Agathion-JD/Assets/main/foro_alura/Captura.PNG)
![](https://raw.githubusercontent.com/Agathion-JD/Assets/main/foro_alura/Captura2.PNG)


![](https://raw.githubusercontent.com/Agathion-JD/Assets/main/foro_alura/Captura5.PNG)
![](https://raw.githubusercontent.com/Agathion-JD/Assets/main/foro_alura/Captura6.PNG)
![](https://raw.githubusercontent.com/Agathion-JD/Assets/main/foro_alura/Captura7.PNG)
![](https://raw.githubusercontent.com/Agathion-JD/Assets/main/foro_alura/Captura8.PNG)

## Autor

**Agathion-JD** 

![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) https://github.com/Agathion-JD

![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white) https://www.linkedin.com/in/daniel-aguirre-lopez/ 
