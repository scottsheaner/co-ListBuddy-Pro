package com.colistbuddy.pro.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.colistbuddy.pro.data.Listing
import kotlinx.coroutines.tasks.await

object FirestoreSync {
    private val db = FirebaseFirestore.getInstance()
    private val auth get() = FirebaseAuth.getInstance()

    suspend fun syncListing(listing: Listing) {
        val uid = auth.currentUser?.uid ?: return
        db.collection("users").document(uid).collection("listings")
            .document(listing.id.toString()).set(listing).await()
    }

    suspend fun deleteListing(listing: Listing) {
        val uid = auth.currentUser?.uid ?: return
        db.collection("users").document(uid).collection("listings")
            .document(listing.id.toString()).delete().await()
    }
}
