plugins {
    idea
    java
}

base.archivesName.set("Luterium")
version = "1.0"
group = "dev.peter"

sourceSets.main {
    java.srcDirs("src/main/java")
}

repositories {
    mavenCentral()
}

val shade: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    shade("org.zeroturnaround:zt-zip:1.15")
    shade("club.minnced:discord-webhooks:0.8.2")
    shade("com.github.sarxos:webcam-capture:0.3.12")
    shade("net.java.dev.jna:jna-platform:4.1.0")
    shade("com.google.code.gson:gson:2.9.1")
    shade("javazoom:jlayer:1.0.1")
}

tasks {
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
        options.encoding = "UTF-8"
        options.isIncremental = true
    }

    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest {
            attributes(
                "Main-Class" to "dev.peter.luterium.Main"
            )
        }
        from(
            shade.map {
                if (it.isDirectory) it
                else zipTree(it)
            }
        )
        exclude(
            "org/intellij/**",
            "org/jetbrains/**",
            "gnu/**",
            "module-info.class",
            "META-INF/maven/**",
            "META-INF/versions/**",
            "META-INF/*.kotlin_module"
        )
    }
}
