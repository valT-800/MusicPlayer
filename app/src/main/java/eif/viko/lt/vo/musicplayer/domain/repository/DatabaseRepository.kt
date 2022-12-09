package eif.viko.lt.vo.musicplayer.domain.repository

import eif.viko.lt.vo.musicplayer.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    fun getItems(): Flow<List<Item>>
}