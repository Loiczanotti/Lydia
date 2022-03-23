object Libs {

    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val KTX = "androidx.core:core-ktx:${Versions.KTX}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"

    const val ANDROID_GRADLE_PLUGIN =
        "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val SAFE_ARGS_PLUGIN =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"

    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    @JvmField
    val DAGGER = arrayOf(
        "com.google.dagger:dagger-android:${Versions.DAGGER}",
        "com.google.dagger:dagger-android-support:${Versions.DAGGER}",
    )

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"


    @JvmField
    val DAGGER_PROCESSORS = arrayOf(
        "com.google.dagger:dagger-compiler:${Versions.DAGGER}",
        "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"
    )


    @JvmField
    val ROOM = arrayOf(
        "androidx.room:room-runtime:${Versions.ROOM}",
        "androidx.room:room-ktx:${Versions.ROOM}",
        "androidx.room:room-rxjava3:${Versions.ROOM}"
    )

    const val ROOM_PROCESSOR = "androidx.room:room-compiler:${Versions.ROOM}"

    @JvmField
    val NAVIGATION = arrayOf(
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}",
        "androidx.navigation:navigation-fragment:${Versions.NAVIGATION}",
        "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    )

    const val RX_JAVA3 = "io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA3}"
    const val RX_KOTLIN = "io.reactivex.rxjava3:rxkotlin:${Versions.RX_KOTLIN}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    @JvmField
    val NETWORK = arrayOf(
        "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}",
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}",
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.RETROFIT}",
        "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
    )

}