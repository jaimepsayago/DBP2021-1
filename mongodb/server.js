/**
 * primera aplicacion en nodejs
 */
'use strict'
//cargar modulos y importar paquetes

//llamar a express
var express = require('express');
//permite manejar rutas
var bodyParser = require('body-parser');

//utilizar express
var app=express();
//puerte
var port = process.env.PORT || 3678;

//configuracion de rutas y el puerto
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

//ruta o direccion web de mi servidor web
//FUNCIONES FLECHAS- REVISARLO EN EL AULA VIRTUAL
app.get('/prueba:nombre?', (req, res) =>{
	
	//request - obtener
	if(req.params.nombre){
		var nombre= req.params.nombre;
	}else{
		var nombre = "SIN NOMBRE";
	}
	
	
	//response - mostrar
	//res.send({texto: "hola mundo con NodeJS y Express"});
	res.status(200).send({
		//array
		data:[5,98,64,78,56],
		//mensaje
		message:"hola mundo desde una variable en eclipse utilziando javascript" + nombre
	});
	
});

//backend o servidor utilice un puerto 3678
//funcion de callback
app.listen(port, function(){
	console.log('servicio web rest funcionando' + 'en http:localhost:' + port);	
	//console.log('hola mundo');
});
