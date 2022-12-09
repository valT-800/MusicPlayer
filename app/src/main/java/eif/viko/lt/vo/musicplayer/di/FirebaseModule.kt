package eif.viko.lt.vo.musicplayer.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.vo.musicplayer.data.repository.FirebaseRepositoryImpl
import eif.viko.lt.vo.musicplayer.domain.repository.FirebaseRepository
import eif.viko.lt.vo.musicplayer.domain.use_case.firestore.GetSongsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirestoreInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseRepository(db: FirebaseFirestore): FirebaseRepository {
        return FirebaseRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun provideSongsUseCase(repository: FirebaseRepository): GetSongsUseCase{
        return GetSongsUseCase(repository)
    }


}