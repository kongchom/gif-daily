// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath(dev.kaycee.buildsrc.Dependencies.gradle)
    classpath(dev.kaycee.buildsrc.Dependencies.kotlinGradle)
    classpath(dev.kaycee.buildsrc.Dependencies.daggerHilt)
    classpath(dev.kaycee.buildsrc.Dependencies.ktLint)

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts.kts files
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}