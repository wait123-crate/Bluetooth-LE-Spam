plugins {
    alias(libs.plugins.agp.app) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.safeargs) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugins.agp)
        classpath(libs.plugins.kotlin)
        classpath(libs.plugins.safeargs)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
 }
plugins {
    alias(libs.plugins.agp.app) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.safeargs) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugins.agp)
        classpath(libs.plugins.kotlin)
        classpath(libs.plugins.safeargs)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
