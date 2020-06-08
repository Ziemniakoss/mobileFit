package com.mobilefit.ui.diet

object DietsBase {

	var dietsList:ArrayList<String> = arrayListOf<String>(
		"diet1",
		"diet2",
		"diet3"
	)

	var dietdeff = "no description available"
	var diet1:String = "dietdescafaafssdfffff"
	var diet2:String = "diet2description"
	var diet3:String = "diet3description"

	fun getDesc( name: String): String {
		return when(name){
			"diet1" -> diet1
			"diet2" -> diet2
			"diet3" -> diet3
			else -> dietdeff
		}
	}


}