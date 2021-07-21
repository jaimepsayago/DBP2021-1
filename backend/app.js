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

//carga todas las funciones y rutas
//localhost:3678/api 
app.use('/api',api); 

//para importar cada fichero que es un modulo
module.exports = app;



