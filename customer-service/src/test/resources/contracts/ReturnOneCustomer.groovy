import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("get one customer")

    request {
        method(GET())
        url("/customers/1")
    }

    response {
        body([age:10, name : "mohsin"])
        status(200)
        headers {
            header("Content-Type" , "application/json")
        }
    }

}