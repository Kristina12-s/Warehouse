dependencies {
    implementation(project(":models"))
    implementation(project(":repository"))
    implementation("org.postgresql:postgresql:42.6.0")
    implementation(project(":repository_sql"))
    implementation(project(":database"))
}

plugins {
    id("java")
    id("org.flywaydb.flyway") version "10.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


flyway {
    url = "jdbc:postgresql://localhost:5432/warehouse"
    user = "admin"
    password = "admin"
    locations = arrayOf("filesystem:src/main/resources/db/migration")
}

