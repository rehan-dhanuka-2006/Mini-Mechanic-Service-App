# 🔧 Mini Mechanic Service App

Instant Mechanic is an Android application designed to help users browse nearby mechanics and garages and request vehicle servicing.

## 📱 Features

- 🚗 Splash screen with Lottie animation
- 🔧 Browse available mechanics
- ⭐ Mechanic ratings
- 📍 Distance and location
- 🟢 Open / Closed status
- 🛠️ Available services
- 📋 Mechanic details
- 🕒 Working hours
- 📞 Phone number
- 📝 Request service form
- ✅ Service request confirmation
- ⏳ Loading state
- ⚠️ Error handling
- 🎨 Lottie animations
- 📱 RecyclerView based UI
- 🏗️ MVVM-inspired architecture

## 🛠️ Tech Stack

- Kotlin
- Android Studio
- XML
- RecyclerView
- CardView
- Retrofit
- Gson
- ViewModel
- LiveData
- Kotlin Coroutines
- Lottie
- Git & GitHub

## 🏗️ Architecture

The application follows an MVVM-inspired architecture.

```text
                UI
                 │
        ┌────────┴────────┐
        │                 │
 MainActivity     MechanicDetailActivity
        │                 │
        └────────┬────────┘
                 ↓
             ViewModel
                 ↓
             Repository
                 ↓
             API / Data

 🔄 User Flow

Splash Screen
      ↓
Home Screen
      ↓
Select Mechanic
      ↓
Mechanic Details
      ↓
Request Service
      ↓
Submit Request
      ↓
Confirmation

📊 Data Handling

The project uses a repository-based mock mechanic data source while maintaining a Retrofit API layer for REST API integration.
The application demonstrates:

API service layer
JSON-compatible data models
Repository pattern
Loading state
Error state
Displaying mechanic data
ViewModel-based UI state management
