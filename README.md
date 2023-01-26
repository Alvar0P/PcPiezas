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
**   Comprador: puede adquirir productos.
**   Comprador VIP: puede adquirir productos con descuentos especiales y sin gastos de envio.
**   Vendedor: puede poner añadir, retirar y editar sus productos.
**   Administrador: acceso completo a la web puede añadir, retirar y editar productos.
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



