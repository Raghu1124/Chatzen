# Chatzen

Chatzen is a real-time chat application built with Kotlin that allows users to securely send messages and make video calls with their friends. It utilizes Firebase as the backend to store data and ensure secure communication. The application supports one-to-one authentication, message storage with unique IDs, and offers a seamless video calling feature using the Jitsi API.

## Features

- **Real-time Messaging**: Send and receive messages instantly with friends.
- **Secure Video Calls**: Create private and secure video call rooms with unique IDs.
- **Firebase Integration**: 
  - Store user credentials and chat history.
  - Unique message IDs for each chat.
  - One-to-one authentication for secure messaging.
- **Interactive UI**: Modern and user-friendly interface for a smooth experience.
- **Jitsi API**: High-quality video calling feature with security and privacy.
  
## Tech Stack

- **Kotlin**: The primary language for the application.
- **Firebase**:
  - **Authentication**: To handle user sign-ins and logins.
  - **Firestore**: For real-time database management and message storage.
- **Retrofit (Jitsi API)**: For implementing video call functionality.
  
## Setup Instructions

### Prerequisites

- [Android Studio](https://developer.android.com/studio)
- Firebase project configured with Firestore and Authentication
- [Jitsi API](https://jitsi.github.io/handbook/docs/dev-guide/dev-guide-android-sdk) for video calls.

### Steps to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/Raghu1124/Chatzen.git
    ```

2. Open the project in Android Studio.

3. Set up Firebase:
    - Go to [Firebase Console](https://console.firebase.google.com/).
    - Create a new project.
    - Add your Android app to the Firebase project.
    - Download and add the `google-services.json` file to the project’s `app` directory.
    - Enable Firebase Authentication and Firestore in the Firebase console.

4. Configure Jitsi API:
    - Follow [Jitsi SDK Documentation](https://jitsi.github.io/handbook/docs/dev-guide/dev-guide-android-sdk) to integrate the Jitsi API for video calls.

5. Build and run the application in an Android emulator or a real device.

## Usage

1. **Sign Up / Log In**: Create an account using your email or log in if you already have an account.
2. **Chat**: Select a friend and start chatting in real-time. Messages are securely stored in Firebase.
3. **Video Call**: Start a video call by creating a secure room with a unique ID.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## Contact

For any inquiries or issues, feel free to contact me at [raghubansal1102@gmail.com](mailto:raghubansal1102@gmail.com).
