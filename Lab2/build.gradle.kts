plugins {
    id("java")
}

group = "ru.itmo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation(project(":core"))

    implementation(project(":dao"))

    implementation("org.springframework.boot:spring-boot-starter-security:3.2.4")

    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.4")
    implementation("org.springframework.boot:spring-boot-starter-test:3.2.4")

    testImplementation("org.mockito:mockito-core:3.10.0")
}

tasks.test {
    useJUnitPlatform()
}