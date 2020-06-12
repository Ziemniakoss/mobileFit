package com.mobilefit.data.exercises

object ExerciseDataBase {

	val db = mapOf(
		ExerciseCategory(1, "abs") to
				listOf<Exercise>(
					Exercise(1, "crunches", 2.0, "up"),
					Exercise(2, "leg raises", 2.1, "lift leg, and down "),
					Exercise(3, "russian twist", 5.0, "1. Spy for USSR, 2.???, 3. PROFIT")
				),
		ExerciseCategory(2, "biceps") to
				listOf<Exercise>(
					Exercise(4, "curls", 2.0, "hold dumbbell, pull, slowly lower"),
					Exercise(5, "hammmer curls", 3.0, "idk, just hammer dem bitch"),
					Exercise(6, "reverse curls", 4.0, "do curls, but in reverse")
				),
		ExerciseCategory(3, "full body") to
				listOf<Exercise>(
					Exercise(7, "pushups", 4.0, "u know how to do them dont lie"),
					Exercise(
						8,
						"paricipating in riots",
						3.0,
						"Shout at cops, throw cocktails, run from the police ACAB"
					),
					Exercise(9, "swimming", 5.0, "move water")
				)
	)
	var exercises: List<Exercise>

	init {
		val tempList = mutableListOf<Exercise>()
		for (aa in db.values) {
			tempList.addAll(aa)
		}
		exercises = tempList
	}

	var cateegories :List<ExerciseCategory>
	init {
		val tempList = mutableListOf<ExerciseCategory>()
		for (key in db.keys){
			tempList.add(key)
		}
		cateegories = tempList
	}
}