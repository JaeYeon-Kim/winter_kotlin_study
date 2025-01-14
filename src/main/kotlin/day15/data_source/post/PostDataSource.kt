package day15.data_source.post

import utils.network.ResponseResult
import day15.model.Post

interface PostDataSource {

    suspend fun getPosts(): ResponseResult<List<Post>>
}