plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android()
    ios()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
//            isStatic = true
        }
    }
    
    sourceSets {

        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.ui)
                api(compose.foundation)
                api(compose.material)
                implementation("com.rickclephas.kmm:kmm-viewmodel-core:1.0.0-ALPHA-4")
                implementation("dev.icerock.moko:resources:0.20.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.activity:activity-compose:1.5.1")
//                implementation("com.rickclephas.kmm:kmm-viewmodel-core:1.0.0-ALPHA-4")

            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by getting {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "shared_resources"
}

android {
    namespace = "com.ahmadhassan.testkmp"
    compileSdk = 33
    sourceSets.getByName("main").res.srcDir(File(buildDir, "generated/moko/androidMain/res"))
//    sourceSets["main"].res.srcDirs("src/androidMain/res")
//    sourceSets["main"].resources.srcDir("src/commonMain/resources")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}