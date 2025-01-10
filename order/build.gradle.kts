plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.netflix.dgs.codegen") version "6.2.1"
	id("nu.studer.jooq") version "8.0"
	id("org.flywaydb.flyway") version "8.0.1"
	id("com.github.spotbugs") version "6.0.8"
	id ("com.diffplug.spotless") version "6.7.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains:annotations:24.0.0")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	jooqGenerator("mysql:mysql-connector-java:8.0.33")
	jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
	implementation(project(":jooq"))
	implementation("com.diffplug.spotless:spotless-plugin-gradle:6.7.2")
	implementation("org.springframework.boot:spring-boot-starter-validation")
}

apply(plugin = "com.diffplug.spotless")

tasks.withType<Test> {
	useJUnitPlatform()
}

spotless {
	java {
		googleJavaFormat()
		removeUnusedImports()
	}
}