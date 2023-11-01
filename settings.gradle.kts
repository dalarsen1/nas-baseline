rootProject.name = "gradle-java-template"

pluginManagement {
  repositories {
    gradlePluginPortal()
    maven {
      name = "codev-gradle-artifactory"
      url = uri("https://repo.codev.mitre.org/artifactory/idaass-gradle")
      val codevUser: String by settings
      val codevPassword: String by settings
      credentials {
        username = codevUser
        password = codevPassword
      }
    }
  }

  plugins {
    val tdpCookbookVersion: String by settings
    id("org.mitre.tdp.gradle-cookbook") version tdpCookbookVersion
  }
}
