plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    mavenCentral()
}

val jUnitVersion by extra("5.9.0")
val assertjVersion by extra("3.23.1")

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}