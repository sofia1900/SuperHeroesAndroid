# SuperHeroesAndroid
Superheroes personal project - Android (Kotlin)

# Description
Superheroes is a personal project with which you can see a glimpse of what I have learned about Android mobile programming
during the second year of my higher degree in Multiplatform Application Development.

This project consist of developing a mobile application that shows a list of superheroes and details of each one of them
by clicking on it.

To do this, I have used the model view - model view (MVVM) architecture pattern, coroutines, dependency injection with Hilt,
several design patterns and a CustomView to show errors, using in the process a clean architecture and good practices.

About information storage, there are two types: local and remote, and the philosophy followed is this: if the information is
found locally, the app returned it from local and, if not, the app collected it from remote, saved it locally and returned it. 
For local storage the app uses Shared Preferences and/or Room, while for remote the app uses Retrofit which will be migrated 
to Firebase then.
