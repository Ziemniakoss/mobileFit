package com.mobilefit.data.quests

data class Quest(
	var id: Int = 0, var name: String = "",
	var description: String = "", var xp: Int = 10, var done: Boolean = false
)