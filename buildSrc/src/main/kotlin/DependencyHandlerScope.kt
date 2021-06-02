import org.gradle.kotlin.dsl.DependencyHandlerScope

fun buildDependencyString(dependency: String, version: String = "") = "$dependency:$version"

fun DependencyHandlerScope.useProtobuf() {
    "implementation"(buildDependencyString(Dependencies.protobufJavaUtil, DependenciesVer.protobufJavaUtil))
    "implementation"(buildDependencyString(Dependencies.protocGenKt, DependenciesVer.protocGenKt))
    "implementation"(buildDependencyString(Dependencies.protobufGradlePlugin, DependenciesVer.protobufGradlePlugin))
    "implementation"(buildDependencyString(Dependencies.javaxAnnotation, DependenciesVer.javaxAnnotation))
}

fun DependencyHandlerScope.useGrpc() {
    useProtobuf()
    "implementation"(buildDependencyString(Dependencies.grpc("all"), DependenciesVer.grpc))
    "implementation"(buildDependencyString(Dependencies.grpc("protobuf"), DependenciesVer.grpc))
    "implementation"(buildDependencyString(Dependencies.grpc("stub"), DependenciesVer.grpc))
    "implementation"(buildDependencyString(Dependencies.grpc("netty"), DependenciesVer.grpc))
    "implementation"(buildDependencyString(Dependencies.grpc("kotlin-stub"), DependenciesVer.grpcKt))
    "implementation"(buildDependencyString(Dependencies.grpcSpringBootStarter, DependenciesVer.grpcSpringBootStarter))
}

fun DependencyHandlerScope.useSpringBoot() {
    "implementation"(buildDependencyString(Dependencies.springBootWeb))
    "implementation"(buildDependencyString(Dependencies.springBootDevTools))
}
