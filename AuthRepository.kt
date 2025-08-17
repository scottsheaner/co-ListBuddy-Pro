package com.colistbuddy.pro.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AuthRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val currentUser: FirebaseUser?
        get() = auth.currentUser

    suspend fun signInEmail(email: String, password: String): FirebaseUser? {
        return try {
            auth.signInWithEmailAndPassword(email, password).await().user
        } catch (e: Exception) {
            null
        }
    }

    suspend fun registerEmail(email: String, password: String): FirebaseUser? {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await().user
        } catch (e: Exception) {
            null
        }
    }

    fun signOut() {
        auth.signOut()
    }
}
