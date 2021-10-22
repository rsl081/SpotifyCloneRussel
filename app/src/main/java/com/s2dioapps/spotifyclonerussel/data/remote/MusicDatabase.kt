package com.s2dioapps.spotifyclonerussel.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.s2dioapps.spotifyclonerussel.data.entities.Song
import com.s2dioapps.spotifyclonerussel.other.Constants
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.tasks.await

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(Constants.SONG_COLLECTION)


    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        }catch (e: Exception) {
            emptyList()
        }
    }
}