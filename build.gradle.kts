plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "com.app"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("com.app.MainKt")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.app.MainKt"
    }
}
