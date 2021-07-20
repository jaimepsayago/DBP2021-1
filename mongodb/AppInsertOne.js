/**
 * 
 */

//libreria de node que permite conectarme con mongodb
var MongoClient = require('mongodb').MongoClient;

//crear una cadena de conexion junto a una funcion para enviar parametros a mongo

MongoClient.connect('mongodb://localhost:27017/dbp',{useNewUrlParser: true,useUnifiedTopology: true},
	function(err, client){
		if (err) throw err;
	
	//variable a insertar o codificacion para insertar en bdd
	var db = client.db('dbp'); //bdd
	
	var doc = {'estudiante': 'jaime sayago','docimilio': 'tachina','telefono':0984755}; //datos a insertar
	
	//insertar la coleccion a la base de datos utilizando los comandos de bdd
	db.collection('estudiantes').insertOne(doc, function(err, inserted)
	{
		if(err) throw err; //controlar el error
		console.log("insertados: " + JSON.stringify(inserted));
	});
	
	
	
});