import org.json.JSONArray

pluginManagement {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}

buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		// Not possible to access "libs" here to use versions catalog.
		@Suppress("UseTomlInstead")
		classpath("org.json:json:20231013")
	}
}

rootProject.name = "Personal Multiapp"

// Applying modules.
val modulesJson = JSONArray(File("modules_list.json").readText())
modulesJson.forEach {
	val moduleObject = it as org.json.JSONObject
	val module = moduleObject.getString("module")
	val path = moduleObject.getString("path")
	include(module)
	project(module).projectDir = File(rootDir, path)
	println("Include module $module by path rootDir/$path")
}
