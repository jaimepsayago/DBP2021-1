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

//obtener un dato es decir buscar
function getEmployee(req, res){
	//viene desde el http desde la pagina web
	var id = req.params.id;
	res.status(200).send({data:id});
	
	
}


//guardar datos

function saveEmployee(req, res){
	var employee = new Employee();
	
	//body = cuerpo de la pagina web 
	//post y params lo convierte en JSON
	var params = req.body;
	
	employee.name = params.name;
	employee.email = params.email;
	employee.designation = params.designation;
	employee.phoneNumber = params.phoneNumber;
	
	employee.save((err, employeeStored)=>{
		if(err){
			res.status(500).send({message:'error al guardar el dato'});
		}
		res.status(200).send({employee:employeeStored});
		
	});
	
}

//editar datos
function updateEmployee(req, res){
	var id = req.params.id;
	var params = req.body;
	
	Employee.findByIdAndUpdate(id, params, (err, employeeUpdate)=>{
		if(err){
			res.status(500).send({message:'error de actualizacion'});
		}
		res.status(200).send({employee:employeeUpdate});
		
	})
	
	
	
}
//eliminar
function deleteEmployee(req,res){
	var id = req.params.id;
	res.status(200).send({delete:true,data:id});
}



//exportar al modulo a objeto
module.exports={
	prueba,
	getEmployees,
	getEmployee,
	saveEmployee,
	updateEmployee,
	deleteEmployee
}




