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
//obtener todos
api.get('/employees/', employeeController.getEmployees);
//buscar un empleado por id
api.get('/employee/:id',employeeController.getEmployee);
//guardar
api.post('/employee',employeeController.saveEmployee);
//editar
api.put('/employee/:id',employeeController.updateEmployee);
//eliminar
api.delete('/employee/:id',employeeController.deleteEmployee);
//exportar la ruta
module.exports=api;
