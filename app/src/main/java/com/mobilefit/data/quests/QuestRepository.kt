package com.mobilefit.data.quests

import com.mobilefit.data.Result

class QuestRepository() {
	val questDataSource = QuestDataSource;
	fun get(id: Int): Result<Quest> {
		return questDataSource.get(id)
	}

	fun getAll(): Result<List<Quest>> {
		return questDataSource.getAll()
	}

	/**
	 * Zaznacz że dany użytkownik wykonał dane zadanie lub go nie wykonał
	 */
	fun markAs(quest: Quest, done: Boolean) {
		quest.done = done
	}
}