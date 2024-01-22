# SuperHeroesAndroid
Super Heroes personal project - Android (Kotlin)

# Description
Súper Héroes is a personal project with which you can see a glimpse of what I have learned about Android mobile programming
during the second year of my higher degree in Multiplatform Application Development.

This project consists of developing a mobile application that shows a list of superheroes and details of each one of them.
by clicking on it.

To do this, I have used the model view - model view (MVVM) architecture pattern, coroutines, dependency injection with Hilt,
several design patterns, a CustomView to show errors and at all times a clean architecture and good practices.

Regarding the storage of information, there are two types: local and remote, and the philosophy followed is the following: if
found locally, returned from local and, if not, collected from remote, saved locally and returned. For storage
local, at the moment Shared Preferences is used, later another local data source, Room, will be added and to manage
The remote data is used Retrofit, which will later be migrated to Firebase.
