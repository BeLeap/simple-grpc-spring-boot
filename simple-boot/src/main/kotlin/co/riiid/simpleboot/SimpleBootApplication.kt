package co.riiid.simpleboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleBootApplication

fun main(args: Array<String>) {
    runApplication<SimpleBootApplication>(*args)
}
