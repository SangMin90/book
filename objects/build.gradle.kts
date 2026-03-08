plugins {
    kotlin("jvm") version "1.9.23"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.10")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}