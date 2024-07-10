package com.rdnbrs.kotlin_mvn_soap_demo.demo

import com.rdnbrs.kotlin_mvn_soap_demo.gen.GetCountryRequest
import com.rdnbrs.kotlin_mvn_soap_demo.gen.GetCountryResponse
import com.rdnbrs.kotlin_mvn_soap_demo.gen.ResponseHeader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class CountryEndpoint @Autowired constructor(private val countryRepository: CountryRepository) {
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    fun country(@RequestPayload request: GetCountryRequest): GetCountryResponse {
        val response: GetCountryResponse = GetCountryResponse()
        response.country = countryRepository.findCountry(request.name)
        var responseHeader = ResponseHeader()
        responseHeader.status = "Success"
        responseHeader.message = "Message 1"
        response.responseHeader = responseHeader

        return response
    }

    companion object {
        private const val NAMESPACE_URI = "http://www.rdnbrs.com/kotlin_mvn_soap_demo/gen"
    }
}