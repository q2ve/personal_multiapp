import com.android.sdklib.AndroidVersion

plugins {
	alias(libs.plugins.application)
	alias(libs.plugins.kotlin)
}

android {
	namespace = "com.q2ve.personal_multiapp"
	compileSdk = AndroidVersion.VersionCodes.TIRAMISU // Android 13, API level 33

	defaultConfig {
		applicationId = "com.q2ve.personal_multiapp"
		minSdk = AndroidVersion.VersionCodes.O_MR1 // Android 8.1, API level 27
		targetSdk = AndroidVersion.VersionCodes.TIRAMISU // Android 13, API level 33
		versionCode = 1
		versionName = "0.0.1"
	}

	buildTypes {
		debug {
			isMinifyEnabled = false
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_19
		targetCompatibility = JavaVersion.VERSION_19
	}
	kotlinOptions {
		jvmTarget = "19"
	}
	buildFeatures {
		viewBinding = true
	}
}
