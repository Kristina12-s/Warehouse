plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":models"))
    implementation(project(":repository"))
    implementation("org.postgresql:postgresql:42.6.0")
}