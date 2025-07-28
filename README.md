Para crear esta app he usado Java 21 y windows 10. 

Una vez descargado y abierto el repo, para iniciar la app introducimos en la consola:

./gradlew clean build
./gradlew bootRun

Y en nuestro navegador la URL correspondiente:

http://localhost:8080/todos

NOTAS

1.- Hay que tener la variable de entorno de java debidamente configurada para que el proyecto arranque, además de un servidor MySQL ejecutándose.

2.- En el fichero application.properties se detalla el usuario y pw de MySQL, actualmente está configurado como usuario=root y password vacía.

3.- Para que la app arranque, la BD tiene que estar creada en el gestor de BBDD con nombre todobd y con un usuario de prueba. En la raíz del proyecto está el archivo sql.
