package io.corbs.randomness

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressAPI {

    @GetMapping("/address")
    fun address(): String {
        return street() + "," + city() + "," + state()
    }

    @GetMapping("/address/street")
    fun street(): String {
        return Randomness.streetAddress
    }

    @GetMapping("/address/city")
    fun city(): String {
        return Randomness.city
    }

    @GetMapping("/address/state")
    fun state(): String {
        return Randomness.state
    }

    @GetMapping("/address/zipcode")
    fun zipcode(): String {
        return Randomness.zipCode
    }
}
