plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "2.1.0"
  id("org.jetbrains.intellij") version "1.17.4"
}

group = "com.lucas.lambda"
version = "1.1-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
}

intellij {
  version.set("2025.1")
  type.set("IC")
  plugins.set(listOf("yaml", "properties"))
  instrumentCode.set(false)
}

tasks {
  buildSearchableOptions {
    enabled = false
  }

  withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
  }
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
  }

  patchPluginXml {
    sinceBuild.set("251")
    untilBuild.set("253.*")
  }

  /*signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }*/

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}


