<p align="center">
  <img src="/Other resources/PcPiezasLogo.png?raw=true" alt="PcPiezasLogo"/>
</p>

# PcPiezas
Web para la compra de ordenadores a piezas y perifericos.

## Características

* Configurador que permite al usuario elegir las piezas y comprueba que estas sean compatibles entre si.
* Venta de ordenadores montados con piezas preconfiguradas.
* Venta de periferícos y otros accesorios
* No hace falta estar registrado para ver los productos

## Entidades

* Productos: tienen un precio, características y piezas compatibles. 
* Configuración: Ordenadores ya montados que el usuario podrá editar.
* Venta: Guarda los datos de la venta (Dirección de envío,total a pagar, fecha de la compra, productos comprados).
* Usuario: usuarios con distintos roles (Comprador, comprador VIP, vendedor, administrador).
  * Comprador: puede adquirir productos.
  * Comprador VIP: puede adquirir productos con descuentos especiales y sin gastos de envio.
  * Vendedor: puede poner añadir, retirar y editar sus productos.
  * Administrador: acceso completo a la web puede añadir, retirar y editar productos.
* Item: para el carrito.
* Carrito: para los productos que se desean comprar.




## Servicios

* Genera factura en pdf y la envía por mail al comprador.
* Si el producto no es de PcPiezas se le evnía un mail al vendedor de los productos que tiene que enviar.
* Envía un correo con estado del producto (Enviado, en reparto...).

## Funciones Privadas

* Gestión de usuarios.
* Gestión de productos.
* Ver el historial de ventas.
* Seguimiento de producto comprado.


## Funciones Públicas.

* Comprar
* Vender
* Usar el configurador
# Fase 2

## Diagrama UML

<p align="center">
  <img src="/Other resources/class diagram.png?raw=true" alt="Diagrama UML"/>
</p>

## Diagrama Entidad Relación

<p align="center">
  <img src="/Other resources/Diagrama EER.png?raw=true" alt="Diagrama EER"/>
</p>

## Capturas de pantalla.

### Caractersticas implementadas
* Añadir eliminar y ver productos
* Consultar y gestionar el inventario para todos los productos o un producto en concreto
* Añadir elementos al carrito para realizar una compra
* Gestión de usuarios

### Gestión de inventario
![11ListaStock](https://user-images.githubusercontent.com/104164229/221727882-c91a2bea-0945-40c9-83a1-881d5784fa6c.png)
### Página de Inicio
![1inicio](https://user-images.githubusercontent.com/104164229/221727884-15d80769-454b-4c53-b8a5-021e4528018d.png)
### Menu desplegable
![2MenuDesplegable](https://user-images.githubusercontent.com/104164229/221727885-297e5215-5e81-4fb4-887f-ea80cc08c7d4.png)
### Página de Componentes
![3componentes](https://user-images.githubusercontent.com/104164229/221727886-9a14b5fc-5933-46fc-b081-69513f222547.png)
### Página de Móviles
![4moviles](https://user-images.githubusercontent.com/104164229/221727887-306a0755-8a81-45c4-8a9b-d7ba2aa969d8.png)
### Página de Ordenadores
![5ordenadores](https://user-images.githubusercontent.com/104164229/221727888-1926f37e-e523-4449-a6b4-e2844edfff21.png)
### Página de Periféricos
![6perifericos](https://user-images.githubusercontent.com/104164229/221727890-504b3ca3-62c9-4893-9196-d9b10d6c3a07.png)
### Carrito
![7carrito](https://user-images.githubusercontent.com/104164229/221727892-a4e79d8a-be4b-4424-9975-f0e1f3a2f10c.png)
### Añadir Producto
![8RegistrarProductos](https://user-images.githubusercontent.com/104164229/221727895-486b644c-2f29-442e-b17c-46e7c9329a22.png)
### Ver Todos los Productos
![9ListaProductos](https://user-images.githubusercontent.com/104164229/221727897-a5fbe192-ba28-4e47-9961-1222b505a3d4.png)
### Añadir Stock a los Productos
![10AnadirStock](https://user-images.githubusercontent.com/104164229/221727898-9102e867-41d7-44ab-aa5f-3261bf2e5713.png)



## Fase 3
* Comunicacion con RabbitMq entre la aplicacion y el servicio de envio de correo electronica

# Instrucciones para desplegar openstack
## Maquina Local
Clonar el repositorio
```
git clone https://github.com/Alvar0P/PcPiezas --tag FASE-3
```
Ir a la ruta de la aplicaion principal
```
cd PcPiezas/PcPiezasIJ/
```
Compilar con maven
```
mvn clean package
```
Ir a la ruta del servicio de correo
```
cd PcPiezas/PcPiezasMailService/
```
Compilar con maven
```
mvn clean package
```
#Transferir los ejecutables al servidor
```
scp PcPiezas-0.0.1-SNAPSHOT.jar (usuario)@(direccion-ip):/PcPiezasEjecutables
scp PcPiezasMailService-0.0.1-SNAPSHOT.jar (usuario)@(direccion-ip):/PcPiezasEjecutables
```

## Maquina Remota

Instalacion mysql
Añadimos el repositorio
```
wget https://dev.mysql.com/get/mysql-apt-config_0.8.22-1_all.deb
sudo dpkg -i mysql-apt-config*
```
Instalamos mysql-server siguiendo los pasos del instalador
```
sudo apt update
sudo apt install mysql-server
```
Abrimos la consola mysql
```
mysql -u root -p
```
Configuramos la base de datos
```
create database pcpiezas;
CREATE USER 'PcPiezasAdmin'@'localhost' IDENTIFIED BY 'bgnkwekwgrkqjvfq';
GRANT ALL PRIVILEGES ON * . * TO 'PcPiezasAdmin'@'localhost';
FLUSH PRIVILEGES;
quit
```

Iniciar Rabbitmq en un contenedor Docker
```
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3-management&
```
Ejecutar ambas aplicaciones en segundo plano
```
java -jar PcPiezas-0.0.1-SNAPSHOT.jar
```
```
java -jar PcPiezasMailService-0.0.1-SNAPSHOT.jar
```
## Fase 4

### Arquitectura de la aplicación
<p align="center">
  <img src="/Other resources/diagramaDAD4.png?raw=true" alt="PcPiezasLogo"/>
</p>
La aplicacion se encuentra en 5 maquinas virtuales de openstack, cada una de estas maquínas virtuales tiene uno o mas contenedores docker, las funciones de cada máquina virtual son las siguientes

* haproxy-rabbitmq: ejecuta 2 contenedores uno con el balanceador de carga haproxy y otra con rabbitmq, esta es la unica máquina con su ip publica expuesta para recibir conexiones por parte de los clientes
* PcPiezasApp1/2: estas máquinas son identicas y cada una ejecuta 4 instancias de la aplicación web principal
* PcPiezasMailService: esta máquina ejecuta dos instancias del servicio interno
* mysql: esta máquina ejecuta una instancia de la base de datos sql


### Instrucciones despligue
Primero debemos crear las 5 máquinas virtuales en openstack y instalar docker en estas
Para hacer este proceso mas facil podemos docker en una máquina y despues crear un snapshot de esta para crear el resto
Para instalar docker ejecutaremos los siguientes comandos:
```
curl https://get.docker.com > dockerInstall.sh
chmod +x ./dockerInstall.sh
sudo ./dockerInstall.sh
```
#### Maquina local
Ahora compialremos las imagenes de docker del servicio interno y la aplicacion principal y las subiremos a dockerhub

Empezaremos por clonar el repositorio
```
git clone https://github.com/Alvar0P/PcPiezas
```
Despues nos dirijiremos al directorio ./PcPiezasIJ, construimos y subimos la imagen con los siguientes comandos
```
sudo docker build . -t <usuario>/pcpiezas-app:latest -f ./docker/buildImage-dockerfile 
sudo docker push <usuario>/pcpiezas-app:latest -f 
```
en nuestro caso
```
sudo docker build . -t alvaromz/pcpiezas-app:latest -f ./docker/buildImage-dockerfile 
sudo docker push alvaromz/pcpiezas-app:latest -f 
```
Despues nos dirijiremos al directorio ./PcPiezasMailService, construimos y subimos la imagen con los siguientes comandos
```
sudo docker build . -t <usuario>/pcpiezas-mail:latest -f ./docker/buildImage-dockerfile 
sudo docker push <usuario>/pcpiezas-mail:latest -f 
```
en nuestro caso
```
sudo docker build . -t alvaromz/pcpiezas-app:latest -f ./docker/buildImage-dockerfile 
sudo docker push alvaromz/pcpiezas-app:latest -f 
```

Ahora debemos transferir los archivos docker compose a los servidores correspondientes 
* ./docker/mysql/docker-compose.yml -> mysql
* ./docker/haproxy-rabbitmq/ -> haproxy rabbitmq
* -/PcPiezasIJ/docker/docker-compose.yml -> PcPiezasApp
* -/PcPiezasIJ/docker/docker-compose.yml -> PcPiezasMail

Antes de transferir los archivos se recomienda editarlos para poner las IPs correspondientes de cada maquina, ademas de el login del correo en el caso de PcPiezasMailService y el archivo haproxy.cfg para indicar las IPs de los nodos

Para esto usaremos scp ejecutando los siguientes comandos en nuestra maquina local
```
scp -i sshFile -r ./docker/mysql/docker-compose.yml debian@<ip-addres>:/home/debian/
scp -i sshFile -r ./docker/haproxy-rabbitmq/ debian@<ip-addres>:/home/debian/
scp -i sshFile -r ./docker/PcPiezasIJ/docker/docker-compose.yml debian@<ip-addres>:/home/debian/
scp -i sshFile -r ./docker/PcPiezasMailService/docker/docker-compose.yml debian@<ip-addres>:/home/debian/
```

Por ultimo debemos ejecutar

```
sudo docker compose up
```
En todas las maquinas virtuales y ya tendriamos la aplicacion desplegada

Para iniciar varias instancias en el caso de la maquína PcPiezasApp
```
sudo docker compose up --scale pcpiezasapp=4
```





