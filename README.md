Arquitectura MoviesFeedApp

La arquitectura consiste toma como base un modelo vista controlador, donde la vista esta encargada de todos los eventos 
relacionados con las interfaces de usuario, dentro de la aplicacion lo podemos encontrar dentro del paquete view en los 
subpaquetes de activity y fragment las cuales son representaciones de la logica que involucra los eventos del usuario,
para los eventos que interactuan con la persistencia de datos se encuentra la capa del modelo, donde se realizan las 
validaciones y se recuperan los datos almacenados en la base de datos por medio de metodos REST, concretamente se puede 
encontrar en las clases dentro de los paquetes de model y el paquete de service, donde se representan los diferentes metodos
para acceder desde la aplicacion a los datos almacenados dentro de los servidores, los cuales cumplen las distintas 
necesidades de datos de la aplicacion. Por ultimo se encuentra la capa del controlador la cual permite comunicar los
datos a las interfaces traves de adaptadores, en la aplicacion se pueden visualizar dentro del paquete de view en el subpaquete
adapter donde se detallan metodos para comunicar la informacion obtenida hacia los elementos encargados de permitir la visualizacion
del contenido en la aplicacion.

Responsabilidad de las clases

