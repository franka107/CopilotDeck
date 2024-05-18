plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.copilot.deck.android.application.jacoco)
    alias(libs.plugins.roborazzi)
    alias(libs.plugins.sonarqube)
}

sonarqube {
    properties {
        // Required
        property("sonar.host.url", "https://sonarqube.app.mrmisti.com")
        property("sonar.token", "sqp_6b65badc1b504ad43fa8512807436b0678d57294")
        property("sonar.projectKey", "copilotdeck2")
        property("sonar.coverage.jacoco.xmlReportPaths", "**/jacoco/**/*Report.xml")
        // Optional
        property("sonar.sources", "src/main/java")
        property("sonar.tests", "src/test/java")
        property("sonar.sourceEncoding", "UTF-8")
        property(
            "sonar.exclusions",
            "**/*Test*/**," +
                "*.json," +
                "**/*test*/**," +
                "**/.gradle/**," +
                "**/R.class," +
                "**/R.class," +
                "**/R\$*.class," +
                "**/BuildConfig.*," +
                "**/Manifest*.*," +
                "**/*_Hilt*.class," +
                "**/*Test*.*,",
        )
    }
}

android {
    namespace = "com.mrmisti.copilot.deck"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mrmisti.copilot.deck"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlin.test)
}
