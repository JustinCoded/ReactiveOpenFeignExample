import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<BootRun>() {
    this.mainClass.set("com.justincoded.reactiveopenfeigndemo.fluxapi.FluxApiApplication")
}
