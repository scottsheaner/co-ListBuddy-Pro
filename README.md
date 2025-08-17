# co-ListBuddy-Pro (Firebase stubs)

This version adds **Firebase stubs** for Authentication and Firestore sync.

## Instructions
1. Create a Firebase project.
2. Enable **Authentication** (Email/Password + Google sign-in).
3. Enable **Cloud Firestore**.
4. Download `google-services.json` and place it in `app/`.
5. App code includes:
   - `AuthRepository.kt` for sign-in/register/logout.
   - `FirestoreSync.kt` for listing sync (call from `ListingsViewModel` after local insert/update/delete).
6. Build the app in Android Studio; ensure the Firebase plugin is applied and KAPT is enabled.
