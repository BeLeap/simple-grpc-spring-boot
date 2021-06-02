object Dependencies {
    const val protobufJavaUtil = "com.google.protobuf:protobuf-java-util"
    const val protocGenKt = "io.grpc:protoc-gen-grpc-kotlin"
    const val protobufGradlePlugin = "com.google.protobuf:protobuf-gradle-plugin"
    const val javaxAnnotation = "javax.annotation:javax.annotation-api"

    const val grpcSpringBootStarter = "io.github.lognet:grpc-spring-boot-starter"

    fun grpc(module: String) = "io.grpc:grpc-$module"

    const val springBootWeb = "org.springframework.boot:spring-boot-starter-web"
    const val springBootDevTools = "org.springframework.boot:spring-boot-devtools"

    const val kotlinxCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core"
}
