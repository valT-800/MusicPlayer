package eif.viko.lt.vo.musicplayer.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.vo.musicplayer.data.repository.DatabaseRepositoryImpl
import eif.viko.lt.vo.musicplayer.data.repository.FirebaseRepositoryImpl
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository
import eif.viko.lt.vo.musicplayer.domain.repository.FirebaseRepository
import eif.viko.lt.vo.musicplayer.domain.use_case.database.GetItemsUseCase
import eif.viko.lt.vo.musicplayer.domain.use_case.firestore.GetSongsUseCase
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
    fun provideItemsUseCase(repository: DatabaseRepository): GetItemsUseCase {
        return GetItemsUseCase(repository)
    }

}