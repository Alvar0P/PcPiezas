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

![11ListaStock](https://user-images.githubusercontent.com/104164229/221727882-c91a2bea-0945-40c9-83a1-881d5784fa6c.png)
![1inicio](https://user-images.githubusercontent.com/104164229/221727884-15d80769-454b-4c53-b8a5-021e4528018d.png)
![2MenuDesplegable](https://user-images.githubusercontent.com/104164229/221727885-297e5215-5e81-4fb4-887f-ea80cc08c7d4.png)
![3componentes](https://user-images.githubusercontent.com/104164229/221727886-9a14b5fc-5933-46fc-b081-69513f222547.png)
![4moviles](https://user-images.githubusercontent.com/104164229/221727887-306a0755-8a81-45c4-8a9b-d7ba2aa969d8.png)
![5ordenadores](https://user-images.githubusercontent.com/104164229/221727888-1926f37e-e523-4449-a6b4-e2844edfff21.png)
![6perifericos](https://user-images.githubusercontent.com/104164229/221727890-504b3ca3-62c9-4893-9196-d9b10d6c3a07.png)
![7carrito](https://user-images.githubusercontent.com/104164229/221727892-a4e79d8a-be4b-4424-9975-f0e1f3a2f10c.png)
![8RegistrarProductos](https://user-images.githubusercontent.com/104164229/221727895-486b644c-2f29-442e-b17c-46e7c9329a22.png)
![9ListaProductos](https://user-images.githubusercontent.com/104164229/221727897-a5fbe192-ba28-4e47-9961-1222b505a3d4.png)
![10AnadirStock](https://user-images.githubusercontent.com/104164229/221727898-9102e867-41d7-44ab-aa5f-3261bf2e5713.png)



