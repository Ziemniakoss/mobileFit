package com.mobilefit.data.quests

import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException

//todo
object QuestDataSource {
	val quests = listOf<Quest>(
		Quest(1, "Runner", "Run 1km", 100),
		Quest(2, "Runner mk2", "Run 2km", 200),
		Quest(3, "Hulk", "Train ", 1000),
		Quest(4, "2Fast4Fat", "Run for 2 hours without stops", 10000),
		Quest(5, "Kurwa terminator", "Destroy atlas while exercising", 2000)
	)

	fun get(id: Int): Result<Quest> {
		for (quest in quests) {
			if (quest.id == id) {
				return Result.Success(quest);
			}
		}
		return Result.Error(NotFoundException())
	}

	fun getAll(): Result<List<Quest>> {
		return Result.Success(quests);
	}
}