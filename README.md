## VPC
Primero se configura una red privada virtual, la cual permitira por medio de grupos de seguridad el acceso a la base de datos que se implementara posteriormente. Lo primero que se debe hacer es, en la consola de AWS entrar en la opcion VPC.
![Ocion VPC de AWS](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/1.png)
Luego nos debemos dirigir a la opcion Security Groups que se encuentra a la izquierda de la pantalla.
![Security Groups](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/2.png)
Se nombra el nuevo grupo de seguridad y se crea.
![Nuevo Security Group](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/3.png)
En la ventana de Security Groups aparecera el nuevo grupo, el cual vamos a seleccionar para cambiar sus inbound rules.
![Security Group Creado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/4.png)
![Inbound Rules](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/5.png)
Se debe adicionar una nueva regla.
![Nueva Inbound Rule](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/6.png)
En esta regla permitiremos que se pueda usar el puerto 3306, que es el que usara nuestra base de datos MySQL.
![VPC Confugurado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/VPC/7.png)
Esta es la configuracion del VPC en el cual estara montada la base de datos.
## RDS
Para crear la base de datos nos vamos a dirigir a la opcion RDS, ya que la base de datos que se creara para el ejemplo es relacional.
![Dashboard RDS](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/1.png)![Amazon RDS](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/2.png)
Seleccionamos la opcion de crear una base de datos.
![Nueva base de datos](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/3.png)
Seleccionamos las configuraciones, en este caso se usara una base de datos MySQL con el servicio standard de RDS para evitar cargos extra.
![Seleccion del motor](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/4.png)
Por esta razon se selecciona la opcion free tier de los templates que brinda amazon.
![Seleccion del template](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/5.png)
Despues de esto se configuran el usuario y contrasena mediante el cual nos conectaremos a la base de datos.
![Configuracion de autenticacion](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/6.png)
Despues de esto cambiaremos la configuracion del VPC, para usar el que creamos en pasos anteriores. Tambien se debe asegurar que el acceso a la base sea publico.
![Acceso Publico](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/7.png)
Se selecciona el VPC creado y se configura el puerto de la base de datos, en este caso el 3306.
![Configuracion de VPC](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/8.png)
Luego de esto se configura el nombre de la base de datos, en este caso es una base de cursos, por lo cual se llama Subjects.
![Nombre de la base de datos](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/9.png)
Cuando volvemos al listado de bases de datos de RDS aparecera la base que acabamos de crear, se debe esperar hasta que esta este disponible, lo cual puede tardar unos minutos.
![Base recien creada](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/10.png)
Seleccionamos la base de datos nueva para asi poder ver sus configuraciones y caracteristicas. De estas seran muy importantes el endpoint y el puerto. 
![Configuraciones de la base](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/11.png)
Ahora nos conectaremos por medio de DBiever a la base de datos en RDS.
![Conexion mediante DBiever](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/12.png)
Se realiza la conexion teniendo en cuenta los datos de la base de datos que nos brinda AWS y las configuraciones que hicimos.
![Conexion a la base](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/13.png)
Si los datos y las credenciales son correctas deberia aparecer una pantalla como la siguiente.
![Conexion exitosa](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/14.png)
En DBiever podremos ver la base de datos que creamos bajo el nombre Subjects, esta por el momento esta vacia.
![Base de datos vacia](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/15.png)
Creamos una tabla y la poblamos para realizar las pruebas del API.
![Creacion y poblado de tablas](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/16.png)
Luego de ejecutar estos comandos la base deberia aparecer de la siguiente forma.
![Tabla creadas](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/17.png)
Una vez hecho esto, se accedera a estos datos desde el API Rest, de la cual se tienen las fuentes en este repositorio.
![Acceso desde el API](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/18.png)
Ahora agregaremos un curso mas a la base de datos desde DBiever.
![Nueva entrada en la tabla](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/19.png)
Este cambio deberia evidenciarse desde el API Rest.
![Cambio reflejado en el API Rest](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/RDS/20.png)
## EC2
En las pruebas realizadas con el API Rest en el paso anterior se puede ver que esta estaba corriendo localmente, por lo que ahora la desplegaremos en el servicio EC2 de AWS. El API esta hecho mediante Spring.
Lo primero que haremos es ir al dashboard de EC2.
![Dashboard de EC2](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/1.png)
Crearemos una instancia de maquina virtual en linux, que tenga java.
![Maquina virtual creada](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/2.png)
En la maquina desplegada vamos a instalar la version 1.8 de java, para lo cual se utilizaran los siguientes dos comandos.
 - `sudo yum install java-1.8.0`
 - `sudo yum remove java-1.7.0-openjdk`
![Java 1.8 instalado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/3.png)
Teniendo instalada la version correcta de java vamos a usar el servicio sftp para subir a la maquina virtual el archivo ejecutable con el API Rest.
![Archivo jar subido a la maquina virtual](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/4.png)
Para permitir la conexion mediante HTTP vamos a habilitar el puerto 8080 en AWS. Para esto iremos a los Security Groups del dashboard de EC2.
![Security Groups EC2](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/5.png)
Vamos a editar las inbound rules para agregar el puerto.
![Puerto 8080 habilitado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/6.png)
Luego de esto nos conectaremos de forma remota a la maquina por medio de SSH y ejecutaremos el archivo jar con el servicio Rest.
![Ejecucion del archivo jar](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/7.png)
Por ultimo probaremos el API con la ruta que provee EC2, deberia dar el mismo resultado que con el servicio corriendo de forma local.
![API Corriendo en EC2](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/EC2/8.png)
## S3
Por ultimo, vamos a subir un recurso estatico a una instancia de almacenamiento S3 de AWS. Para esto vamos a dirigirnos al dashboard de S3.
![S3 AWS](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/1.png)
Seleccionamos la opcion para crear un nuevo bucket.
![Nuevo bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/2.png)
Luego de nombrar el bucket vamos a avanzar hasta la configuracion de permisos.
![Configuracion del bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/3.png)
Una vez en esta configuracion vamos a permitir el acceso publico.
![Configuracion de permisos del bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/4.png)
Avanzamos en la configuracion sin mover ningun parametro y creamos el bucket.
![Creacion del bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/5.png)
![Bucket creado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/6.png)
Una vez creada la instancia vamos a subir un elemento estatico. Para esto entramos en el bucket que acabamos de crear y seleccionamos la opcion para subir un archivo.
![Bucket seleccionado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/7.png)
![Subir un archivo al bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/8.png)
En este caso se subio la calculadora HTML utilizada en el proyecto de primer tercio.
![Archivo cargado en el bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/9.png)
Se avanza en las configuraciones hasta que el archivo este totalmente subido en el bucket.
![Configuraciones de subida del recurso](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/10.png)![Fin del upload](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/11.png)
El bucket deberia verse asi despues de subir el archivo.
![Archivo subido](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/13.png)
Ahora nos dirigiremos a la URL del objeto para poder verlo desplegado en el bucket.
![Overview del bucket](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/14.png)
![Acceso denegado](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/15.png)
Como se pudo ver, el acceso al recurso fue denegado, por esto vamos a configurar los permisos del mismo. Nos dirigimos a la seccion de permisos y habilitamos la opcion de lectura para todos.
![Configuracion de permisos de lectura](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/16.png)
Desoues de esto volvemos a acceder a la URL.
![Acceso permitido](https://raw.githubusercontent.com/Alejoguzm07/AREP6/master/images/S3/17.png)
El recurso es visible y se permite el acceso mediante la URL.


