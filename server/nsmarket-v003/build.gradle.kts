import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.14" apply false
	id("io.spring.dependency-management") version "1.0.15.RELEASE"

	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"

	kotlin("kapt") version "1.6.21"
}

java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
	mavenCentral()
}


allprojects{
	group = "com.NsMarket"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin-kapt")

	dependencies {
		// JWT 인증
		implementation("com.auth0:java-jwt:3.19.2")

		// Kotlin 로깅
		implementation("io.github.microutils:kotlin-logging:1.12.5")

		// Kotlin
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

		//. H2DB
		runtimeOnly("com.h2database:h2")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		implementation("org.springframework.boot:spring-boot-starter:2.5.4")

		//db
		implementation("dev.miku:r2dbc-mysql:0.8.1.RELEASE")
		implementation("io.r2dbc:r2dbc-pool")
		runtimeOnly("com.mysql:mysql-connector-j")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
		implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")

		implementation("org.jetbrains.kotlin:kotlin-reflect")

		//SpringDoc
		implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
		implementation("org.springdoc:springdoc-openapi-webflux-ui:1.7.0")


		implementation("org.springframework.boot:spring-boot-starter-webflux")
		implementation("org.springframework.boot:spring-boot-starter-web")

		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

		kapt("org.springframework.boot:spring-boot-configuration-processor")
		implementation("at.favre.lib:bcrypt:0.9.0")

		runtimeOnly("com.mysql:mysql-connector-j")
		implementation("org.springframework.boot:spring-boot-starter-jdbc")


		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("io.projectreactor:reactor-test")


		//s3 의존성
//    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")
//    implementation("software.amazon.awssdk:s3:2.17.14")
//    implementation("com.amazonaws:aws-java-sdk-s3") // AWS SDK for S3
		implementation("com.amazonaws:aws-java-sdk-s3:1.11.1015")
	}

	dependencyManagement{
		imports {
			mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
		}
	}





}


//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//import org.springframework.boot.gradle.tasks.bundling.BootJar
//
//plugins {
//	id("org.springframework.boot") version "2.7.15"
//	id("io.spring.dependency-management") version "1.0.15.RELEASE"
//	kotlin("jvm") version "1.6.21"
//	kotlin("plugin.spring") version "1.6.21" apply false
//	kotlin("plugin.jpa") version "1.6.21" apply false
//}
//
//java.sourceCompatibility = JavaVersion.VERSION_17
//
//allprojects {
//	group = "com.example"
//	version = "0.0.1-SNAPSHOT"
//
//	repositories {
//		mavenCentral()
//	}
//}
//
//subprojects {
//	apply(plugin = "java")
//
//	apply(plugin = "io.spring.dependency-management")
//	apply(plugin = "org.springframework.boot")
//	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
//
//	apply(plugin = "kotlin")
//	apply(plugin = "kotlin-spring") //all-open
//	apply(plugin = "kotlin-jpa")
//
//	dependencies {
//		// springboot
//		implementation("org.springframework.boot:spring-boot-starter-web")
//		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//		developmentOnly("org.springframework.boot:spring-boot-devtools")
//
//		// kotlin
//		implementation("org.jetbrains.kotlin:kotlin-reflect")
//		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//
//		// DB
//
//		// test
//		testImplementation("org.springframework.boot:spring-boot-starter-test")
//	}
//
//	dependencyManagement {
//		imports {
//			mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
//		}
//
//		dependencies {
//			dependency("net.logstash.logback:logstash-logback-encoder:6.6")
//		}
//	}
//
//	tasks.withType<KotlinCompile> {
//		kotlinOptions {
//			freeCompilerArgs = listOf("-Xjsr305=strict")
//			jvmTarget = "17"
//		}
//	}
//
//	tasks.withType<Test> {
//		useJUnitPlatform()
//	}
//
//	configurations {
//		compileOnly {
//			extendsFrom(configurations.annotationProcessor.get())
//		}
//	}
//}
//
//// module core 에 module api, consumer이 의존
//project(":market-user-service") {
//	dependencies {
//		implementation(project(":market-core-service"))
//	}
//}
//
//project(":market-board-service") {
//	dependencies {
//		implementation(project(":market-core-service"))
//	}
//}
//
//// core 설정
//project(":market-core-service") {
//	val jar: Jar by tasks
//	val bootJar: BootJar by tasks
//
//	bootJar.enabled = false
//	jar.enabled = true
//
//}