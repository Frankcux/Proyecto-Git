# Proyecto-Git
La temática del proyecto es referente al sistema que permite llevar control sobre la participación y evaluación de mascotas en un concurso organizado por la ciudadela.

Para la realización del proyecto, los estudiantes deben definir los constructores, getter, setter, toString, equals, y demás comportamientos necesarios.

El proyecto debe presentar el siguiente menú de opciones, en caso de que el usuario no ingrese un número de opción correcto se debe volver a presentar el menú de opciones, de igual manera si ya se hizo uso de alguna opción se debe regresar al menú de opciones.

Menú de opciones
1.	Dueño
2.	Mascota
3.	Concurso
4.	Premio
5.	Criterio
6.	Inscripción
7.	MiembroJurado
8.	Evaluacion
La opción 1 de Dueño recibe los datos de un dueño por teclado y almacena la información del dueño en el archivo dueños.txt.

La opción 2 de Mascota recibe los datos de una mascota por teclado y además el email del dueño al que pertenece (el email es para buscar el id del dueño para asociarlo a la mascota), la información de la mascota se almacena en el archivo mascotas.txt.

La opción 3 de Concurso recibe los datos de un concurso y almacena la información en el archivo concursos.txt.

La opción 4 de Premio solicita por teclado una cantidad de premios, luego se recepta la información de cada premio y al final se recibe el nombre del concurso al que pertenecen esos premios (el nombre es para buscar el id del concurso para asociarlo a los premios). Los premios se guardan en el archivo premios.txt.

La opción 5 de Criterio solicita por teclado una cantidad de criterios, luego se recepta la información de cada criterio y al final se recibe el nombre del concurso al que pertenecen esos premios (el nombre es para buscar el id del concurso para asociarlo a los criterios). Los criterios se guardan en el archivo criterios.txt.

La opción 6 de Inscripción recibe un nombre de mascota y un nombre de concurso por teclado (el nombre de la mascota y el concurso es para buscar los respectivos ids). Además, se solicita el valor a pagar de la inscripción, no es necesario validar el número de mascotas para recibir un descuento, solo se debe solicitar el valor a pagar y la fecha de la inscripción. Las inscripciones se guardan en el archivo inscripciones.txt.

La opción 7 de MiembroJurado recibe los datos de un miembro del jurado por teclado y almacena la información del dueño en el archivo miembroJurados.txt.

La opción 8 de Evaluación recibe el email del jurado, el id de la inscripción, el id del criterio que va evaluar y la nota de la evaluación que desea poner el miembro del jurado. La información de las evaluaciones se guarda en el archivo evaluaciones.txt.

