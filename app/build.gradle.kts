
plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
  id("org.jlleitschuh.gradle.ktlint")
}

android {
  compileSdkVersion(30)
  buildToolsVersion("30.0.0")

  defaultConfig {
    applicationId = "dev.kaycee.gifdaily"
    minSdkVersion(23)
    targetSdkVersion(30)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    javaCompileOptions {
      annotationProcessorOptions {
        arguments.plusAssign(
          hashMapOf(
            "room.schemaLocation" to "$projectDir/schemas",
            "room.incremental" to "true",
            "room.expandProjection" to "true"
          )
        )
      }
    }
  }

  buildFeatures.viewBinding = true

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  packagingOptions {
    exclude("META-INF/*.kotlin_module")
  }

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  // Kotlin
  implementation(dev.kaycee.buildsrc.Dependencies.kotlin)

  // Coroutines
  implementation(dev.kaycee.buildsrc.Coroutines.core)
  implementation(dev.kaycee.buildsrc.Coroutines.android)

  // Android
  implementation(dev.kaycee.buildsrc.Android.appcompat)
  implementation(dev.kaycee.buildsrc.Android.activityKtx)
  implementation(dev.kaycee.buildsrc.Android.coreKtx)
  implementation(dev.kaycee.buildsrc.Android.constraintLayout)
  implementation(dev.kaycee.buildsrc.Android.swipeRefreshLayout)

  // Architecture Components
  implementation(dev.kaycee.buildsrc.Lifecycle.viewModel)
  implementation(dev.kaycee.buildsrc.Lifecycle.liveData)

  // Room components
  implementation(dev.kaycee.buildsrc.Room.runtime)
  implementation(dev.kaycee.buildsrc.Room.ktx)
  kapt(dev.kaycee.buildsrc.Room.compiler)

  // Material Design
  implementation(dev.kaycee.buildsrc.Dependencies.materialDesign)
  implementation(dev.kaycee.buildsrc.Dependencies.materialDialog)

  // Coil-kt
  implementation(dev.kaycee.buildsrc.Dependencies.coil)

  // Retrofit
  implementation(dev.kaycee.buildsrc.Retrofit.retrofit)
  implementation(dev.kaycee.buildsrc.Retrofit.moshiRetrofitConverter)

  // Moshi
  implementation(dev.kaycee.buildsrc.Moshi.moshi)
  implementation(dev.kaycee.buildsrc.Moshi.codeGen)
  kapt(dev.kaycee.buildsrc.Moshi.codeGen)

  // Hilt + Dagger
  implementation(dev.kaycee.buildsrc.Hilt.hiltAndroid)
  implementation(dev.kaycee.buildsrc.Hilt.hiltViewModel)
  kapt(dev.kaycee.buildsrc.Hilt.daggerCompiler)
  kapt(dev.kaycee.buildsrc.Hilt.hiltCompiler)

  // Navigation
  implementation(dev.kaycee.buildsrc.Navigation.navFragment)
  implementation(dev.kaycee.buildsrc.Navigation.navUI)

  // Testing
  testImplementation(dev.kaycee.buildsrc.Testing.core)
  testImplementation(dev.kaycee.buildsrc.Testing.coroutines)
  testImplementation(dev.kaycee.buildsrc.Testing.room)
  testImplementation(dev.kaycee.buildsrc.Testing.okHttp)
  testImplementation(dev.kaycee.buildsrc.Testing.jUnit)

  // Android Testing
  androidTestImplementation(dev.kaycee.buildsrc.Testing.extJUnit)
  androidTestImplementation(dev.kaycee.buildsrc.Testing.espresso)

  //Glide
  implementation(dev.kaycee.buildsrc.Dependencies.glide)
  kapt(dev.kaycee.buildsrc.Dependencies.glideCompiler)
}

ktlint {
  android.set(true)
  outputColorName.set("RED")
}