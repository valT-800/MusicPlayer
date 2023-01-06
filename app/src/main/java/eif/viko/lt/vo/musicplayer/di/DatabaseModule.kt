package eif.viko.lt.vo.musicplayer.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.vo.musicplayer.data.repository.DatabaseRepositoryImpl
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository
import eif.viko.lt.vo.musicplayer.domain.use_case.database.UseCases
import eif.viko.lt.vo.musicplayer.domain.use_case.database.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference {
        return Firebase.database.reference
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(db: DatabaseReference): DatabaseRepository {
        return DatabaseRepositoryImpl(db)
    }


    @Provides
    @Singleton
    fun provideUseCases(
        repository: DatabaseRepository
    ) = UseCases(
        getPlaylists = GetPlaylistsUseCase(repository),
        getMyPlaylists = GetMyPlaylistsUseCase(repository),
        addPlaylist = AddPlaylistUseCase(repository),
        deletePlaylist = DeletePlaylistUseCase(repository),
        getMyPlaylistTracks = GetMyPlaylistTracksUseCase(repository),
        getPlaylistTracks = GetPlaylistTracksUseCases(repository),
        getFavoriteTracks = GetFavoriteTracksUseCase(repository),
        getAllTracks = GetAllTracksUseCase(repository),
        addTrackToFavorites = AddTrackToFavoritesUseCase(repository),
        addTrackToPlaylist = AddTrackToPlaylistUseCase(repository),
        removeTrackFromFavorites = RemoveTrackFromFavoritesUseCase(repository),
        removeTrackFromPlaylist = RemoveTrackFromPlaylistUseCase(repository)

    )

}