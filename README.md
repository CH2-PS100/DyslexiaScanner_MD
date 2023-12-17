# DyslexiaScanner_MD

## Firebase Config

To make the google-services.json config values accessible to Firebase SDKs, you need the Google services Gradle plugin.

## 1. To make the google-services.json config values accessible to Firebase SDKs, you need the Google services Gradle plugin.

Kotlin DSL (build.gradle.kts)

Add the plugin as a dependency to your project-level build.gradle.kts file:

Root-level `(project-level)` Gradle file `(<project>/build.gradle.kts):`

```plugins {
// ...

// Add the dependency for the Google services Gradle plugin
id("com.google.gms.google-services") version "4.4.0" apply false

}
```

## 2. Then, in your module (app-level) build.gradle.kts file, add both the google-services plugin and any Firebase SDKs that you want to use in your app:

Module (app-level) `Gradle file (<project>/<app-module>/build.gradle.kts):`

```plugins {
id("com.android.application")

// Add the Google services Gradle plugin
id("com.google.gms.google-services")

...
}

dependencies {
// Import the Firebase BoM
implementation(platform("com.google.firebase:firebase-bom:32.6.0"))

// TODO: Add the dependencies for Firebase products you want to use
// When using the BoM, don't specify versions in Firebase dependencies
implementation("com.google.firebase:firebase-analytics")

// Add the dependencies for any other desired Firebase products
// https://firebase.google.com/docs/android/setup#available-libraries
}
```

## 3. After adding the plugin and the desired SDKs, sync your Android project with Gradle files.

# OR

## 1. To make the google-services.json config values accessible to Firebase SDKs, you need the Google services Gradle plugin.

Groovy (build.gradle)

Add the plugin as a dependency to your project-level `build.gradle file:`

Root-level (project-level) Gradle file `(<project>/build.gradle):`

```plugins {
  // ...

  // Add the dependency for the Google services Gradle plugin
  id 'com.google.gms.google-services' version '4.4.0' apply false

}
```

## 2. Then, in your module (app-level) `build.gradle` file, add both the `google-services` plugin and any Firebase SDKs that you want to use in your app:

Module (app-level) Gradle file `(<project>/<app-module>/build.gradle):`

`````
plugins {
id 'com.android.application'

// Add the Google services Gradle plugin
id 'com.google.gms.google-services'

...
}

dependencies {
  // Import the Firebase BoM
  implementation platform('com.google.firebase:firebase-bom:32.6.0')


  // TODO: Add the dependencies for Firebase products you want to use
  // When using the BoM, don't specify versions in Firebase dependencies
  implementation 'com.google.firebase:firebase-analytics'


  // Add the dependencies for any other desired Firebase products
  // https://firebase.google.com/docs/android/setup#available-libraries
}````
`````

## 3. After adding the plugin and the desired SDKs, sync your Android project with Gradle files.
