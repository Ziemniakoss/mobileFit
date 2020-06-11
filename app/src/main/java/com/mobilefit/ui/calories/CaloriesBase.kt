package com.mobilefit.ui.calories

object CaloriesBase {

	var caloriesList:ArrayList<String> = arrayListOf<String>(
		"Apple",
		"Avocado",
		"Banana",
		"Beer Light",
		"Beer Regular",
		"Blueberries",
		"Bread White",
		"Bread Wholemeal",
		"Camembert",
		"Cheddar",
		"Chocolate",
		"Chocolate Dark",
		"Chocolate White",
		"Cornflakes",
		"Cranberries",
		"Edam Cheese",
		"Feta Cheese",
		"Figs",
		"Fruit Salad",
		"Gouda",
		"Grapes",
		"Grounded Beef",
		"Kiwi",
		"Lemon",
		"Lime",
		"Mozzarella",
		"Mango",
		"Muesli",
		"Noodles",
		"Olives",
		"Orange",
		"Pasta",
		"Papaya",
		"Peach",
		"Pepperoni",
		"Pineapple",
		"Potatoes Boiled",
		"Potatoes Roasted",
		"Raspberries",
		"Rice White",
		"Rice Brown",
		"Spaghetti",
		"Strawberries",
		"Tofu",
		"Watermelon"


	)

	var caloriesdeff = 0.0



	fun getCalories( name: String): Double {
		return when(name){
			"Apple"-> 0.52
			"Avocado"-> 1.6
			"Banana"-> 0.88
			"Beer Light"-> 0.32
			"Beer Regular"-> 0.42
			"Blueberries"-> 0.57
			"Bread White"-> 2.4
			"Bread Wholemeal"-> 2.2
			"Camembert"-> 4.35
			"Cheddar"-> 2.86
			"Chocolate"-> 5.0
			"Chocolate Dark"-> 6.07
			"Chocolate White"->5.78
			"Cornflakes"-> 3.7
			"Cranberries"->  0.46
			"Edam Cheese"-> 3.6
			"Feta Cheese"-> 2.67
			"Figs"-> 0.74
			"Fruit Salad"-> 0.5
			"Gouda"-> 3.6
			"Grapes"-> 0.68
			"Grounded Beef"-> 2.35
			"Kiwi"-> 0.61
			"Lemon"-> 0.29
			"Lime"-> 0.29
			"Mozzarella"-> 2.67
			"Mango"-> 0.6
			"Muesli"-> 3.9
			"Noodles"-> 0.7
			"Olives"-> 0.74
			"Orange"-> 0.47
			"Pasta"-> 1.1
			"Papaya"-> 0.43
			"Peach"-> 0.39
			"Pepperoni"-> 5.28
			"Pineapple"-> 0.5
			"Potatoes Boiled"-> 0.7
			"Potatoes Roasted"-> 1.4
			"Raspberries"-> 0.52
			"Rice White"-> 1.4
			"Rice Brown"-> 1.35
			"Spaghetti"-> 1.01
			"Strawberries"-> 0.32
			"Tofu"-> 0.78
			"Watermelon"-> 0.3
			else -> caloriesdeff
		}
	}


}