/**
 * primera aplicacion en nodejs
 */
'use strict'
//cargar modulos y importar paquetes

//llamar a express
var express = require('express');

//utilizar express
var app=express();

//backend o servidor utilice un puerto 3678
//funcion de callback

app.listen(3678, function(){
	console.log('servicio web rest funcionando' + 'en http:localhost:3678');	
	
});
