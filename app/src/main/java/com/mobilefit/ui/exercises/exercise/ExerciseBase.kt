package com.mobilefit.ui.exercises.exercise

object ExerciseBase {

	var exdeff = "no description available"
	var exa1:String = "exdescafaafssdfffff"
	var exa2:String = "exa2description"
	var exa3:String = "exa3description"


	fun getDesc( name: String): String {
		return when(name){
			"exa1" -> exa1
			"exa2" -> exa2
			"exa3" -> exa3
			else -> exdeff
		}
	}
}