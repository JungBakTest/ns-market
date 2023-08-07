import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.11" apply false
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
//    id("application")
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
    group = "com.market"
    version = "0.0.1-SNAPSHOT2"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-kapt")


//    apply(plugin = "application")

    dependencies {
        // JWT 인증
        implementation("com.auth0:java-jwt:3.19.2")

        // Kotlin 로깅
        implementation("io.github.microutils:kotlin-logging:1.12.5")



        // Kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")



        //springfox
//        implementation("io.springfox:springfox-swagger-ui:3.0.0")
//        implementation("io.springfox:springfox-boot-starter:3.0.0")
        implementation(kotlin("stdlib-jdk8"))
        //SpringDoc
        implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
        implementation("org.springdoc:springdoc-openapi-webflux-ui:1.7.0")
//        implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
//        implementation("org.springdoc:springdoc-openapi-kotlin:1.6.9")
        //. H2DB
//        runtimeOnly("com.h2database:h2")


        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    dependencyManagement{
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
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


tasks.withType<Jar>{
    manifest{
        attributes["Main-Class"] = "com.market.NsMarketUserServiceApplication"
    }
}

//tasks.register("prepareKotlinBuildScriptModel"){}

//project("user-service"){
//    jar{
//
//    }
//}