package com.rdnbrs.kotlin_mvn_soap_demo.demo

import com.rdnbrs.kotlin_mvn_soap_demo.gen.Country
import com.rdnbrs.kotlin_mvn_soap_demo.gen.Currency
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.springframework.util.Assert

@Component
class CountryRepository {
    @PostConstruct
    fun initData() {
        val spain: Country = Country()
        spain.name = "Spain"
        spain.capital = "Madrid"
        spain.currency = Currency.EUR
        spain.population = 46704314

        countries[spain.name] = spain

        val poland: Country = Country()
        poland.name = "Poland"
        poland.capital = "Warsaw"
        poland.currency = Currency.PLN
        poland.population = 38186860

        countries[poland.name] = poland

        val uk: Country = Country()
        uk.name = "United Kingdom"
        uk.capital = "London"
        uk.currency = Currency.GBP
        uk.population = 63705000

        countries[uk.name] = uk
    }

    fun findCountry(name: String): Country? {
        Assert.notNull(name, "The country's name must not be null")
        return countries[name]
    }

    companion object {
        private val countries: MutableMap<String, Country> = HashMap<String, Country>()
    }
}
