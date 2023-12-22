# DyslexiaScanner_MD

## Documentation APP
<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/09e2ce08-c361-415e-94d9-ca546dfd7a80" width="200">
<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/a3c56a18-9b7c-41f8-a03c-c74bed11f0dc" width="200">

<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/ff062665-a9eb-4d19-a4ba-ee1ea458305f" width="200">

<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/9d08c20e-46a0-4885-bd7e-29c167801875" width="200">

<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/e094f80f-d362-43d6-a120-741f76983173" width="200">

<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/0b2e3120-9b61-4ab6-89ab-2e8821be9fe5" width="200">


<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/06a660f5-7642-452c-9456-bae924d7149e" width="200">
<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/f53996f9-032e-4827-8dfc-50b652b51069" width="200">
<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/1a60a148-6518-40a4-a2f6-8226dd1db697" width="200">
<img src="https://github.com/CH2-PS100/DyslexiaScanner_MD/assets/106803028/f3aaf6ad-757c-4be7-895e-d9daeebae544" width="200">






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
