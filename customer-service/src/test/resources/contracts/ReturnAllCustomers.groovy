package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("return all of the customers")

    request {
        method(GET())
        url("/customers")
    }

    response {
        body(["mohsin" , "omar"])
        status(200)
        headers {
            header("Content-Type" , "application/json")
        }
    }


}