group = "org.example"
version = "0.1-SNAPSHOT"

plugins {
    kotlin("multiplatform") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    val binaryName = "linux_app"
    val entryPointName = "main"
    linuxX64 {
        binaries {
            executable(binaryName) {
                entryPoint = entryPointName
            }
        }
    }
    linuxArm32Hfp("linuxArm32") {
        binaries {
            executable(binaryName) {
                entryPoint = entryPointName
            }
        }
    }
    linuxArm64 {
        binaries {
            executable(binaryName) {
                entryPoint = entryPointName
            }
        }
    }
}
