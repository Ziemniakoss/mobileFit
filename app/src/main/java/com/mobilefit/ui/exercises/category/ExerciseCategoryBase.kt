package com.mobilefit.ui.exercises.category

object ExerciseCategoryBase {

	var exercisesList:ArrayList<String> = arrayListOf<String>(
		"ex1",
		"ex2",
		"ex3"
	)

	var category1:ArrayList<String> = arrayListOf<String>(
		"exa1",
		"exa2",
		"exa3"
	)

	fun getList( name: String): ArrayList<String> {
		return when(name){
			"category1" -> category1
			else -> exercisesList
		}
	}
}