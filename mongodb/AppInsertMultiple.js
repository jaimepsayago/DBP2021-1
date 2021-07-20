var MongoClient = require('mongodb').MongoClient;

MongoClient.connect('mongodb://localhost:27017/dbp',
//{useNewUrlParser:true, useUnifiedTopology:true},
function(err,client){
if (err) throw err;

//variable de base de datos
var db=client.db('dbp');

//agregar varios registros
var docs = [
{'alumno': 'Ana', 'edad': 15},
{'alumno': 'Susana', 'edad': 25},
{'alumno': 'Juan', 'edad': 99}
];


//el comando de inserta datos en la colección
db.collection('estudiantes').insertMany(docs,
	function(err, insert){
		if (err) throw err;

	console.log("insertados: "+ JSON.stringify(insert));
	});

});