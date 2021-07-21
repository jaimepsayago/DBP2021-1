/**
 * 
 */
'use strict'

var Employee = require('../models/employee');

//operaciones crud

//ejemplo de una ruta 
//que es un metodo para enviar informacion
function prueba(req,res){
	if(req.params.nombre){
    var nombre = req.params.nombre;
  }else{
    var nombre = "SIN NOMBRE";
  }
    res.status(200).send({
        data: [2,3,4,5,6],
        texto: "hola mundo con Node.Js y Express "+nombre});
	
	
}

//obtener todos los objetos desde la base de datos
function getEmployees(req, res){
	//desde el modelo y su schema Employee obtenga los datos
	Employee.find({ }).sort('-name').exec((err, employees)=>{
		if (err){
			res.status(500).send({message: 'error al devolver datos'});
		}else{
			if (!employees){
				res.status(404).send({message: 'no existen datos'});
			}else{
				res.status(200).send({employees});
			}
			
		}
		
	});
}



//exportar al modulo a objeto
module.exports={
	prueba,
	getEmployees
}




