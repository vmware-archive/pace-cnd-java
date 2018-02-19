package io.corbs.randomness;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NamesAPI {

    @GetMapping("/names")
    public String getNames() {
        return RandomKit.getFirstName() + " " + RandomKit.getLastName();
    }

    @GetMapping("/names/first")
    public String getFirstname() {
        return RandomKit.getFirstName();
    }

    @GetMapping("/names/last")
    public String getLastname() {
        return RandomKit.getLastName();
    }
}
