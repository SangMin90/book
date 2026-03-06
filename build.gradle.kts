plugins {
    kotlin("jvm") version "1.9.23" apply false
}

allprojects {
    group = "dev.book"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}