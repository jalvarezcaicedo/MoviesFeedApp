* Arquitectura MoviesFeedApp

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

* Responsabilidad de las clases

Paquete helper
    Util -> Clase de soporte para tareas comunes y almacenamiento de constantes
Paquete model
    Movie -> Pojo encargado de representar los datos de una pelicula
    MoviesResponse -> Pojo correspondiente a los datos recibidos desde la base de datos de tmdb
Paquete service
    APIService -> Interfaces encargadas de definir los diferentes eventos REST de la aplicacion
    BaseService -> Clase abstracta que permite acceder al cliente de retrofit a diferentes interfaces
    RetrofitClient -> Clase encargada de establecer las caracteristicas del cliente de Retrofit para el consumo de los diferentes servicios REST
    Subpaquete repository
        MoviesRepository -> Clase adaptador con la implementacion de las interfaces de APIService que permite interactuar con los metodos REST definidos en la interfaz
Paquete view
    Subpaquete activity
        BaseActivity -> Clase base que soporta los fragments y eventos genericos de la interfaz
        InfoActivity -> Clase encargada de mostrar la información especifica de cualquier elemento seleccionado
    Subpaquete adapter
        MoviesAdapter -> Adaptador utilizado como puente entre la interfaz grafica representada en el fragment y los datos recibidos desde el servicio
        ViewPagerAdapter -> Adaptador encargado de gestionar los eventos correspondientes a la interfaz de paginas donde se muestran los diferentes datos por categorias
    Subpaquete fragment
        PopularFragment -> Fragmento que soporta los datos correspondientes a la categoria de peliculas populares (popular)
        RatedFragment -> Fragmento que soporta los datos correspondientes a la categoria de peliculas mejor valoradas (top rated)
        UpcomingFragment -> Fragmento que soporta los datos correspondientes a la categoria de peliculas proximas (upcoming)


* El principio de responsabilidad unica busca que cada objeto dentro de una representacion cumpla con un unico objetivo, es un principio ideal que
facilita la comprension del codigo, la idea es que cada clase sea tan simple como sea posible de esta forma temas de refactorizacion de codigo y
responsabilidad de clases, mantengan un equilibrio deseado apuntando hacia mantener el bajo acoplamiento y la alta cohesion en el diseño del proyecto,
para lograr este principio es necesario dividir el problema en pequeños problemas logrando facilitar la solucion de cada uno y dando como resultado la suma
de todas las pequeñas soluciones en el problema resuelto

* Determinar que tan limpio es el codigo producido en mi opinion esta basado en 2 pilares, en primer lugar la correcta abstraccion del diseño, donde
el codigo limpio se diferencia del resto al evitar repetir funcionalidades a traves de una correcta implementacion de la reutilizacion junto con una
jerarquia de tareas bien definida. Como segundo pilar en mi opinion se encuentra el mantener la simplicidad del codigo es decir que cada clase
que se construya se explique por si misma, desde una correcta seleccion de nombres hasta una adecuada gestion de responsabilidades entre las clases
son elementos de este pilar que dan resultados a medida que los proyectos se incrementan