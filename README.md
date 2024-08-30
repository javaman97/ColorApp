# ColorCode App 
## Video Demo - Check out the video demo of the ColorCode app:[https://drive.google.com/file/d/1Bhr9mj_7F4Z89CMMB82J3Wen0tEi2p_H/view?usp=sharing]

**ColorCode** is an Android application developed using Jetpack Compose and follows the MVVM architecture. The app allows users to manage and display color entries, both locally and remotely using Firebase. It also includes functionality for syncing data between the local database and Firebase.

## Project Structure

### `data`
- **`ColorDao.kt`**: DAO interface for Room database operations. Defines methods for accessing and manipulating color data in the local database.
- **`ColorDatabase.kt`**: Defines the Room database, including the database holder and the DAOs associated with it.
- **`ColorRepository.kt`**: Manages data operations, including fetching data from the local database and synchronizing with Firebase.
- **`model/ColorEntity.kt`**: Data model representing a color entry, including fields for color value and timestamp.

### `views`
- **`colorcards`**
  - **`ColorCard.kt`**: Composable function for displaying a single color card. Shows the color and other details in a card view.
  - **`ListofColorCards.kt`**: Composable function for the main screen displaying a list of color cards. Manages the layout and interaction of the color cards.
  - **`AddColorExtendedFAB.kt`**: Composable function for the Floating Action Button (FAB) used to add new colors.
  - **`TopBarSyncButton.kt`**: Composable function for syncing the entries with Firebase and roomdatabase.


- **`theme`**
  - **`Color.kt`**: Defines the color themes used throughout the app.
  - **`Typography.kt`**: Defines text styles and typography used in the app.
   - **`Theme.kt`**: Defines Theming that may be Light or Dark 
    
### `viewmodel`
- **`ColorViewModel.kt`**: ViewModel for handling UI-related data and business logic. Manages interactions with the repository and provides data to the UI.
- **`ColorViewModelFactory.kt`**:  Factory for creating instances of ColorViewModel.

## Features

- **Color Management**: Add new colors, view existing colors, and display them in a list.
- **Firebase Integration**: Sync color data with Firebase for remote storage and retrieval.
- **Offline Support**: Store color data locally using Room, allowing access even without internet connectivity.
- **MVVM Architecture**: Clean separation of concerns between UI, data, and business logic.

## Getting Started

### Prerequisites
- Android Studio with Kotlin support
- Firebase account and project setup

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-repo/colorcode-app.git
   cd colorcode-app
