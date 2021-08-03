/**
 * 
 */
'use strict'
//para que se pueda ejecutar
//javascript y sus nuevas versiones en el navegador
//cargar el modulo de express
var express = require('express');
var bodyParser = require('body-parser');
//llamar al paquete express
var app = express();

//cargar rutas
var api = require('./routes/employee');

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());


//vamos a cargar una funcion que se lanza cada vez
//que consumamos el api
//next parametro para salir de la funcion
app.use((req,res,next)=>{
    //con este codigo se indica que cualquiera
    // puede hacer peticiones a mi api rest
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method');
    res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
    res.header('Allow', 'GET, POST, OPTIONS, PUT, DELETE');
    //
    next();
  
});



//carga todas las funciones y rutas
//localhost:3678/api 
app.use('/api',api); 

//para importar cada fichero que es un modulo
module.exports = app;



