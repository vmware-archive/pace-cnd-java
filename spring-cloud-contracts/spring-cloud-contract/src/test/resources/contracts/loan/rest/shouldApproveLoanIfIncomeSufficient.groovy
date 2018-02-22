org.springframework.cloud.contract.spec.Contract.make {
    description("""
Represents a successful scenario of getting a loan

```
given:
	loan amount <= 30% of income
when:
	she applies for a loan
then:
	we'll grant her the loan
```

    """)
    request {
        method POST()
        url "/v1/check"
        body(
            income: 50000, loanAmount: 10000
            )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
            { "status" : "APPROVED" }
        """)
        headers {
            contentType(applicationJson())
        }
    }
}
