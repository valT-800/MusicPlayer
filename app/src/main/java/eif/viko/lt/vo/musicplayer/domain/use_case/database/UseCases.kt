package eif.viko.lt.vo.musicplayer.domain.use_case.database

data class UseCases(
    val getPlaylists: GetPlaylistsUseCase,
    val getMyPlaylists: GetMyPlaylistsUseCase,
    val addPlaylist: AddPlaylistUseCase,
    val deletePlaylist: DeletePlaylistUseCase,
    val getPlaylistTracks: GetPlaylistTracksUseCases,
    val getMyPlaylistTracks: GetMyPlaylistTracksUseCase,
    val getFavoriteTracks: GetFavoriteTracksUseCase,
    val getAllTracks: GetAllTracksUseCase,
    val addTrackToFavorites: AddTrackToFavoritesUseCase,
    val addTrackToPlaylist: AddTrackToPlaylistUseCase,
    val removeTrackFromFavorites: RemoveTrackFromFavoritesUseCase,
    val removeTrackFromPlaylist: RemoveTrackFromPlaylistUseCase

)
