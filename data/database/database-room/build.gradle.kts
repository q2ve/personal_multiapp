import com.android.sdklib.AndroidVersion

plugins {
	alias(libs.plugins.library)
	alias(libs.plugins.kotlinAndroid)
	alias(libs.plugins.ksp)
}

android {
	namespace = "com.q2ve.personal_multiapp.database_room"

	compileSdk = AndroidVersion.VersionCodes.UPSIDE_DOWN_CAKE // Android 14, API level 34

	defaultConfig {
		minSdk = AndroidVersion.VersionCodes.KITKAT // Android 4.4, API level 19
	}

	buildTypes {
		debug {
			isMinifyEnabled = false
		}
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}

	kotlinOptions {
		jvmTarget = "17"
	}
}

dependencies {
	implementation(libs.room)
	ksp(libs.roomcompiler)
	implementation(libs.livedata)
	implementation(project(":database-helpers"))
}
