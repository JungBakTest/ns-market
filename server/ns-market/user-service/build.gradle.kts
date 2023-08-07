

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("at.favre.lib:bcrypt:0.9.0")
//    implementation(kotlin("stdlib-jdk8"))
//    runtimeOnly("io.r2dbc:r2dbc-h2")
    implementation("dev.miku:r2dbc-mysql:0.8.1.RELEASE")
    implementation("io.r2dbc:r2dbc-pool")
    runtimeOnly("com.mysql:mysql-connector-j")
    implementation(kotlin("stdlib-jdk8"))

}

//application{
//    mainClass = "com.market.NsMarketUserServiceApplication"
//}

//tasks.withType<Jar>{
//    manifest{
//        attributes["Main-Class"] = "com.market.NsMarketUserServiceApplication"
//    }
//}

//springBoot {
//    mainClass.set("com.example.MyMainClassKt")
//}