package day15.data_source.user

import utils.network.ResponseResult
import day15.model.User

interface UserDataSource {
    // User 전체 리스트 가져오기
    suspend fun getUsers(): ResponseResult<List<User>>
}