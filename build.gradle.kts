plugins {
    application
    id("org.jetbrains.kotlin.jvm").version("1.3.11")
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
    implementation("org.apache.kafka:kafka-streams:2.3.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "uk.co.kenfos.AppKt"
}
