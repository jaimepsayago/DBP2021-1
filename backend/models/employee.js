/**
 * 
 */

'use strict'

var mongoose = require('mongoose');

//objetos definir para trabajar con bdd
var Schema = mongoose.Schema;

//un objeto

var Employee = Schema({
	name: {
      type: String
   },
   email: {
      type: String
   },
   designation: {
      type: String
   },
   phoneNumber: {
      type: Number
   }
}, 
{
   collection: 'employees'
})

module.exports = mongoose.model('Employee', Employee)
