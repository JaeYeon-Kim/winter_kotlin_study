package day16.exercise.datasource.todo

import utils.network.ResponseResult
import utils.network.safeCall
import day15.model.Todo
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSourceImpl(
    val client: HttpClient = HttpClient(CIO)
) : TodoDataSource {
    override suspend fun getTodos(): ResponseResult<List<Todo>> = withContext(Dispatchers.IO) {
        safeCall {
            client.get("https://jsonplaceholder.typicode.com/todos") {

            }.body<List<Todo>>()
        }
    }

    override suspend fun getTodo(id: Int): ResponseResult<Todo> = withContext(Dispatchers.IO) {
        safeCall {
            client.get("https://jsonplaceholder.typicode.com/todos/$id") {

            }.body<Todo>()
        }
    }

}