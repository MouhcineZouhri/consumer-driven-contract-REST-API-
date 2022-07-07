import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("get one customer")

    request {
        method(GET())
        url("/customers/1")
    }

    response {
        body("mohsin")
        status(200)
    }

}