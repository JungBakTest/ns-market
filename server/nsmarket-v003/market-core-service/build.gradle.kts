import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true


plugins {
    id("org.springframework.boot") version "2.7.14"
    // 다른 필요한 플러그인들을 여기에 추가
}

dependencies {
    //로그 의존성
    api("io.github.microutils:kotlin-logging-jvm:2.0.11")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("dev.miku:r2dbc-mysql:0.8.1.RELEASE")
    implementation("io.r2dbc:r2dbc-pool")
    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
}
