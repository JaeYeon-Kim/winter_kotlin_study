package day15.repository.album

import day15.common.ResponseResult
import day15.data_source.album.AlbumDataSource
import day15.model.Album

class AlbumRepositoryImpl(
    private val albumDataSource: AlbumDataSource
) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        return when (val result = albumDataSource.getAlbums()) {
            is ResponseResult.Success -> {
                if (limit != null) {
                    result.data.take(limit)
                } else {
                    result.data
                }
            }

            is ResponseResult.Failure -> {
                emptyList()
            }
        }
    }
}