import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	//id("org.jetbrains.kotlin.plugin.noarg") version "1.8.0"
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation(project(":domain"))
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// https://mvnrepository.com/artifact/org.postgresql/postgresql
	implementation("org.postgresql:postgresql:42.5.1")
	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
	// https://mvnrepository.com/artifact/org.mockito/mockito-core
	testImplementation("org.mockito:mockito-core:4.8.0")
	// https://mvnrepository.com/artifact/io.mockk/mockk
	testImplementation("io.mockk:mockk:1.12.4")



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

tasks.withType<Wrapper> {
	gradleVersion = "7.6"
}

sourceSets {
	test {
		kotlin {
			srcDirs("test/kotlin")
		}
	}
}