/**
 * 
 */

//llevasr todas las configuracion
//Express
'use strict'

var mongoose = require('mongoose');

//importa 'fichero app.js
var app = require('./app');

//puerto
var port=process.env.PORT || 3678;

//conexion a base de datos
mongoose.connect('mongodb://localhost:27017/dbp',{useNewUrlParser: true, useUnifiedTopology: true }
,(err,res)=>{
  if(err){
    throw err;
  }else{
      console.log('conexion mongo correcta');
      app.listen(port, function(){
        //comilla invertar alt+96
        //sirve para enviar parametros
          console.log(`API REST FAVORITOS FUNCIONANDO en ${port} `);
      });
  }
});
