package com.mobilefit.ui.exercises.category

object ExerciseCategoryBase {

	var abs:ArrayList<String> = arrayListOf<String>(
		"Crunches",
		"Sit_Ups",
		"Leg Raises",
		"Superman",
		"Incline Bench Sit-Ups",
		"Hanging Leg Raises",
		"Dumbbell Side Bends",
		"Flat Bench Lying Leg Raise",
		"Seated Jackknife",
		"Twisting Hip Raise",
		"Bodyweight Crunch",
		"Russian Twist",
		"Slide Bridge",
		"Bodyweight Hip Extension",
		"Rotating T Extension"
	)

	var back:ArrayList<String> = arrayListOf<String>(
		"Chin-Ups",
		"Deadlifts",
		"Lat Pull-Downs",
		"Seated Rows",
		"One-Arm Dumbbell Rows",
		"Barbel Shrugs",
		"Dumbbell Shrugs",
		"Back Extensions",
		"Bent Over Row",
		"Reverse Chin Ups",
		"Bodyweight Superman",
		"Dumbbells Bent Over Row",
		"Stability Ball Hyperextension",
		"Seated Bent Over Row",
		"T-Bar Bent Over Row"
	)

	var biceps:ArrayList<String> = arrayListOf<String>(
		"Curls",
		"Barbell Curls",
		"Preacher Curls",
		"Hammer Curls",
		"Concentration Curls",
		"Reverse Curls",
		"Cable Biceps Curl",
		"Low Pulley Curls",
		"Dumbbell Biceps Curl"

	)
	var calf:ArrayList<String> = arrayListOf<String>(
		"Toe Raising",
		"One-Leg Toe Raises",
		"Seated Calf Raises",
		"Barbell Calf Raise",
		"Barbell Calf Raise With Single Leg",
		"Dumbbell Calf Jump",
		"Dumbbell Calf Raise",
		"Standing Barbell Calf Raise",
		"Standing Dumbbell Calf Raise"
	)
	var exercisesList:ArrayList<String> = arrayListOf<String>(
		"ex1",
		"ex2",
		"ex3"
	)

	var chest:ArrayList<String> = arrayListOf<String>(
		"Bench Presses",
		"Incline Presses",
		"Dumbbell Preses",
		"Parallel Bar Dips",
		"Cable Crossover Flys",
		"Dumbbell Flys",
		"Dumbbell Pullovers",
		"Push-Ups",
		"Dumbbell Pushup",
		"Single Arm Pushup",
		"Weighted Pushup"
	)

	var forearms:ArrayList<String> = arrayListOf<String>(
		"Wrist Curls",
		"Wrist Curls Reverse",
		"Dumbbell Wrist Twist",
		"Standing Wrist Curl"
	)

	var legs:ArrayList<String> = arrayListOf<String>(
		"Squats",
		"Angled Leg Presses",
		"Leg Extensions",
		"Dumbbell Lunges",
		"Cable Back Kicks",
		"Dumbbell Squats",
		"Front Squats",
		"Power Squats",
		"Hack Squats",
		"Barbell Lunge",
		"Barbell Squat Overhead",
		"Bench Jump"
	)

	var shoulders:ArrayList<String> = arrayListOf<String>(
		"Back Presses",
		"Seated Front Presses",
		"Upright Rows",
		"Lateral Raises",
		"Front Raises",
		"Barbell Front Raises",
		"Arnold Press",
		"Dumbbell Scarecrow",
		"Front Weighted Raise",
		"Lateral Weighted Raise",
		"Military Press Behind The Neck"
	)

	var triceps:ArrayList<String> = arrayListOf<String>(
		"Close Grip Bench Presses",
		"Push Downs",
		"Triceps Extensions",
		"Triceps KickBacks",
		"Bar Triceps Extensions",
		"Dumbbell Triceps Extension",
		"Triceps Dips",
		"Triceps Pushdown",
		"Dumbbell Row Kickback",
		"Seated Triceps Extension"
	)

	fun getList( name: String): ArrayList<String> {
		return when(name){
			"ABS" -> abs
			"BACK" -> back
			"BICEPS" -> biceps
			"CALF" -> calf
			"CHEST" -> chest
			"FOREARMS" -> forearms
			"LEGS" -> legs
			"SHOULDERS" -> shoulders
			"TRICEPS" -> triceps
			else -> exercisesList
		}
	}
}



