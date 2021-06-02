import com.google.protobuf.gradle.*

plugins {
    id(Plugins.protobufPlugin) version PluginsVer.protobufPlugin
    id(Plugins.kotlinSpring)
}

the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR1")
    }
}

tasks {
    val pollapoInstall by register<Exec>("pollapoInstall") {
        if (File("$rootDir/.pollapo").exists()) {
            commandLine("echo", "proto files already installed")
        } else {
            workingDir(rootDir)
            commandLine("pollapo", "install")
        }
    }

    matching { it.name != pollapoInstall.name }.all {
        if (this.name == "generateProto") {
            dependsOn(pollapoInstall)
            mustRunAfter(pollapoInstall)
        }
    }
}

dependencies {
    useProtobuf()
    useGrpc()

    useSpringBoot()

    implementation("com.google.protobuf:protobuf-gradle-plugin:0.8.13")
    protobuf(files("$rootDir/.pollapo"))
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.10.1"
    }
    generatedFilesBaseDir = "$projectDir/src/main/kotlin/co.riiid.simpleboot/generated"
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.33.1"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:0.1.5"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}
