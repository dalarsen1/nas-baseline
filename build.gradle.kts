import net.researchgate.release.GitAdapter.GitConfig
import org.mitre.tdp.repositories.codev
import org.mitre.tdp.repositories.from
import org.mitre.tdp.repositories.repo1

plugins {
    `java-library`
    `maven-publish`
    id("org.mitre.tdp.gradle-cookbook")
    id("net.researchgate.release") version "2.8.1" // used to emulate mvn release (see https://github.com/researchgate/gradle-release)
}

tdpConventions {
    `module-checkstyle-conventions`
    `module-javadoc-conventions`
    `module-reporting-conventions`
    `module-testing-conventions`
}

repositories {
    repo1()
    codev.mavenArtifactory {
        mavenContent {
            releasesOnly()
        }
        credentials.from(properties) {
            usernameKey = "codevUser"
            passwordKey = "codevPassword"
        }
    }
}

tdpJavadoc {
    javadocPackageName {
        "${date("yyyy-MM-dd")}-gradle-java-template-${project.version}.zip"
    }
}

release {
    // allow un-versioned files which may have been copied in for use by CI
    failOnUnversionedFiles = false

    preTagCommitMessage = "[Gradle] Bump to stable version "
    newVersionCommitMessage = "[Gradle] Bump to version "

    val git: GitConfig = getProperty("git") as GitConfig
    git.requireBranch = "main"
}

dependencies {

    val junitVersion = "5.9.1"
    "testImplementation"("org.junit.jupiter:junit-jupiter-api:$junitVersion") {
        exclude("ch.qos.logback", "logback-classic")
    }
    "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:$junitVersion") {
        exclude("ch.qos.logback", "logback-classic")
    }

    "testImplementation"("org.mockito:mockito-core:4.9.0")
    "testImplementation"("nl.jqno.equalsverifier:equalsverifier:3.14")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            artifactId = project.name

            from(components["java"])

            pom {
                name.set(project.name)
                organization {
                    name.set("The MITRE Corporation TDP")
                    url.set("https://github.com/mitre-tdp")
                }
                scm {
                    connection.set("scm:git:ssh://git@github.com:mitre-tdp/gradle-java-template.git")
                    developerConnection.set("scm:git:ssh://git@github.com:mitre-tdp/gradle-java-template.git")
                    url.set("https://github.com/mitre-tdp/gradle-java-template")
                    tag.set("HEAD")
                }
            }
        }
    }
    repositories {
        codev.mavenArtifactory {
            credentials.from(rootProject.properties) {
                usernameKey = "codevUser"
                passwordKey = "codevPassword"
            }
        }
    }
}