/**
 * 
 */

'use strict'
var express = require('express');

//importar el controlador 
var employeeController = require('../controllers/employee');

//definir rutas desde la aplicacion app.js
var api = express.Router();

//generamos una funcion para llamar al controlador
api.get('/prueba/:nombre?', employeeController.prueba);
api.get('/employees/', employeeController.getEmployees);

//exportar la ruta
module.exports=api;
