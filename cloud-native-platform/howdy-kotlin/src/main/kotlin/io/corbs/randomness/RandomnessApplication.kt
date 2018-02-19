package io.corbs.randomness

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RandomnessApplication

fun main(args: Array<String>) {
    SpringApplication.run(RandomnessApplication::class.java, *args)
}
