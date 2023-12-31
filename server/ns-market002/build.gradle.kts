import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.14"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("kapt") version "1.6.21"

}

group = "com.market"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	// JWT 인증
	implementation("com.auth0:java-jwt:3.19.2")

	// Kotlin 로깅
	implementation("io.github.microutils:kotlin-logging:1.12.5")

	// Kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	//SpringDoc
	implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
	implementation("org.springdoc:springdoc-openapi-webflux-ui:1.7.0")



	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

//	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	kapt("org.springframework.boot:spring-boot-configuration-processor")
	implementation("at.favre.lib:bcrypt:0.9.0")

	implementation("dev.miku:r2dbc-mysql:0.8.1.RELEASE")
	implementation("io.r2dbc:r2dbc-pool")
	runtimeOnly("com.mysql:mysql-connector-j")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	//aws s3
	implementation("com.amazonaws:aws-java-sdk-s3:1.11.1015")
	implementation(project(":market-board"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
