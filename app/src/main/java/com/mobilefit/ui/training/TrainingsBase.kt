package com.mobilefit.ui.training

object TrainingsBase {

	var trainingList:ArrayList<String> = arrayListOf<String>(
		"training1",
		"training2",
		"training3"
	)

	var trainingdeff = "no description available"
	var training1:String = "trainingdescafaafssdfffff"
	var training2:String = "training2description"
	var training3:String = "training3description"

	fun getDesc( name: String): String {
		return when(name){
			"training1" -> training1
			"training2" -> training2
			"training3" -> training3
			else -> trainingdeff
		}
	}


}