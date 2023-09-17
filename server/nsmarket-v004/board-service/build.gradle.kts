apply(plugin = "kotlin-jpa")

dependencies{
    // JWT 인증
    implementation("com.auth0:java-jwt:3.19.2")
    // Kotlin 로깅
    implementation("io.github.microutils:kotlin-logging:1.12.5")


    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")

    // Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    //s3 의존성
    implementation("com.amazonaws:aws-java-sdk-s3:1.11.1015")

    implementation(project(":user-service"))
//
//    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//    implementation("dev.miku:r2dbc-mysql:0.8.1.RELEASE")
//    implementation("io.r2dbc:r2dbc-pool")
}