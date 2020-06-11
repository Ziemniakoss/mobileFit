package com.mobilefit.ui.diet

object DietsBase {

	/*source:
	* healthline.com
	* */

	var dietsList:ArrayList<String> = arrayListOf<String>(
		"Low-carb, whole-food diet",
		"Mediterranean diet",
		"Paleo diet",
		"Vegan diet",
		"Gluten-free diet"
	)

	var dietdeff = "no description available"
	var diet1:String = "A low-carb diet is a diet that restricts carbohydrates, such as those found in sugary foods, pasta and bread. It is high in protein, fat and healthy vegetables.\n" +
			"\n" +
			"There are many different types of low-carb diets, and studies show that they can cause weight loss and improve health.\n" +
			"Your food choices depend on a few things, including how healthy you are, how much you exercise and how much weight you have to lose.\n" +
			"\n" +
			"Consider this meal plan as a general guideline, not something written in stone.\n" +
			"\n" +
			"Eat: Meat, fish, eggs, vegetables, fruit, nuts, seeds, high-fat dairy, fats, healthy oils and maybe even some tubers and non-gluten grains.\n" +
			"\n" +
			"Don’t eat: Sugar, HFCS, wheat, seed oils, trans fats, “diet” and low-fat products and highly processed foods."

	var diet2:String = "The Mediterranean diet is based on the traditional foods that people used to eat in countries like Italy and Greece back in 1960.\n" +
			"\n" +
			"Researchers noted that these people were exceptionally healthy compared to Americans and had a low risk of many lifestyle diseases.\n" +
			"\n" +
			"Numerous studies have now shown that the Mediterranean diet can cause weight loss and help prevent heart attacks, strokes, type 2 diabetes and premature death.\n"+
			"\n" +
			"Eat: Vegetables, fruits, nuts, seeds, legumes, potatoes, whole grains, breads, herbs, spices, fish, seafood and extra virgin olive oil.\n" +
			"Eat in moderation: Poultry, eggs, cheese and yogurt.\n" +
			"Eat only rarely: Red meat.\n" +
			"Don't eat: Sugar-sweetened beverages, added sugars, processed meat, refined grains, refined oils and other highly processed foods."

	var diet3:String = "The paleo diet is designed to resemble what human hunter-gatherer ancestors ate thousands of years ago.\n" +
			"\n" +
			"Although it’s impossible to know exactly what human ancestors ate in different parts of the world, researchers believe their diets consisted of whole foods.\n" +
			"\n" +
			"By following a whole food-based diet and leading physically active lives, hunter-gatherers presumably had much lower rates of lifestyle diseases, such as obesity, diabetes and heart disease.\n"+
			"There is no one \"right\" way to eat for everyone and paleolithic humans thrived on a variety of diets, depending on what was available at the time and where in the world they lived.\n" +
			"\n" +
			"Some ate a low-carb diet high in animal foods, while others followed a high-carb diet with lots of plants.\n" +
			"\n" +
			"Consider this as a general guideline, not something written in stone. You can adapt all of this to your own personal needs and preferences.\n" +
			"\n" +
			"Eat: Meat, fish, eggs, vegetables, fruits, nuts, seeds, herbs, spices, healthy fats and oils.\n" +
			"\n" +
			"Avoid: Processed foods, sugar, soft drinks, grains, most dairy products, legumes, artificial sweeteners, vegetable oils, margarine and trans fats."

	var diet4:String = "The vegan diet has become very popular.\n" +
			"\n" +
			"Increasingly more people have decided to go vegan for ethical, environmental or health reasons.\n" +
			"\n" +
			"When done right, such a diet may result in various health benefits, including a trimmer waistline and improved blood sugar control.\n"+
			"There are different varieties of vegan diets. The most common include:\n" +
			"\n" +
			"- Whole-food vegan diet: A diet based on a wide variety of whole plant foods such as fruits, vegetables, whole grains, legumes, nuts and seeds.\n" +
			"- Raw-food vegan diet: A vegan diet based on raw fruits, vegetables, nuts, seeds or plant foods cooked at temperatures below 118°F (48°C) (1Trusted Source).\n" +
			"- 80/10/10: The 80/10/10 diet is a raw-food vegan diet that limits fat-rich plants such as nuts and avocados and relies mainly on raw fruits and soft greens instead. Also referred to as the low-fat, raw-food vegan diet or fruitarian diet.\n" +
			"- The starch solution: A low-fat, high-carb vegan diet similar to the 80/10/10 but that focuses on cooked starches like potatoes, rice and corn instead of fruit.\n" +
			"- Raw till 4: A low-fat vegan diet inspired by the 80/10/10 and starch solution. Raw foods are consumed until 4 p.m., with the option of a cooked plant-based meal for dinner.\n"



	var diet5:String = "A gluten-free diet involves excluding foods that contain the protein gluten, including wheat, rye and barley.\n" +
			"\n" +
			"Most studies on gluten-free diets have been done on people with celiac disease, but there is another condition called gluten sensitivity that also causes problems with gluten.\n" +
			"\n" +
			"If you are intolerant to gluten, then you need to avoid it completely. If not, you will experience severe discomfort and adverse health effects\n\n"+
			"Eat: Meats and fish, eggs, dairy, fruits, vegetables, grains, starches, flours, nuts, seeds, spreads, oils, herbs, spices, beverages .\n" +
			"\n" +
			"Don’t eat: Wheat-based foods like wheat bran, wheat flour, spelt, durum, kamut, semolina, barley, rye, triticale, malt, brewer’s yeast."

	fun getDesc( name: String): String {
		return when(name){
			"Low-carb, whole-food diet"-> diet1
			"Mediterranean diet"-> diet2
			"Paleo diet"-> diet3
			"Vegan diet"-> diet4
			"Gluten-free diet"-> diet5
			else -> dietdeff
		}
	}


}