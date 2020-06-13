package com.mobilefit.data.quests

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobilefit.Variables
import com.mobilefit.data.Result
import com.mobilefit.data.users.UserRepository
import com.mobilefit.dto.QuestUpdateDTO
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException
import java.lang.reflect.Type

class QuestRepository() {
	fun get(id: Int): Result<Quest> {
		var result :Result<Quest> = Result.Error(IOException())
		val t = Thread{
			val req = Request.Builder()
				.get()
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.url("${Variables.urlToServer}/quests/${id}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				val fooType: Type? = object : TypeToken<Quest?>() {}.type
				val quest = Gson().fromJson<Quest>(it.body()?.string(), fooType)
				Log.d("Quest", "${quest}  ${quest.completed}")
				result = Result.Success(quest)
			}
		}
		t.start()
		t.join()
		return result
	}

	fun getAll(): Result<List<Quest>> {
		var result : Result<List<Quest>> = Result.Error(IOException())
		val t = Thread{
			val req = Request.Builder()
				.get()
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.url("${Variables.urlToServer}/quests")
				.build()
			OkHttpClient().newCall(req).execute().use {
				val fooType: Type? = object : TypeToken<List<Quest?>?>() {}.type
				val quests = Gson().fromJson<List<Quest>>(it.body()?.string(), fooType)
				result = Result.Success(quests)
			}
		}
		t.start()
		t.join()
		return result
	}

	/**
	 * Zaznacz że dany użytkownik wykonał dane zadanie lub go nie wykonał
	 */
	fun markAs(quest: Quest, done: Boolean) {
		val t = Thread{
			val req = Request.Builder()
				.url("${Variables.urlToServer}/quests/${quest.id}")
				.post(RequestBody.create(Variables.jsonMediaType, Gson().toJson(QuestUpdateDTO(done))))
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				Log.d("Quest update", it.body()?.string())
			}
		}
		t.start()
		t.join()
		quest.completed = done
	}
}