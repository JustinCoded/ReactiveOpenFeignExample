import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    application
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign") // @EnableFeignClients

    implementation("com.playtika.reactivefeign:feign-reactor-webclient")
    implementation("com.playtika.reactivefeign:feign-reactor-spring-cloud-starter") // @EnableReactiveFeignClients

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")



    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.12.0")
}

tasks.withType<BootRun>() {
    this.mainClass.set("com.justincoded.reactiveopenfeigndemo.client.ReactiveOpenfeignDemoApplication")
}

tasks.withType<Test>() {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
