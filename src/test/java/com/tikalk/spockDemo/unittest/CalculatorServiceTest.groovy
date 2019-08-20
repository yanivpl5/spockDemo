package com.tikalk.spockDemo.unittest

import com.tikalk.spockDemo.service.CalculatorService
import spock.lang.Specification

class CalculatorServiceTest extends Specification {

    def "check summing 2 numbers"() {
        when:
        def calculatorService = new CalculatorService()

        then:
        calculatorService.sum(2, 3) == 5
    }

    def "check summing 2 numbers fails"() {
        when:
        def calculatorService = new CalculatorService()

        then:
        calculatorService.sum(2, 3) == 6
    }

    def "check summing 2 numbers 2"() {
        when:
        def calculatorService = new CalculatorService()

        then:
        calculatorService.sum(2, 3) == 5

        and:
        calculatorService.sum(3, 2) == 5
    }

    def "check multiplying 2 numbers"() {

        def name = "yaniv"
        when:

        print "my name is: $name"
        def calculatorService = new CalculatorService()

        then:
        calculatorService.multiply(2, 3) == 6
    }

    def "check summing 2 numbers with parameterized test"() {
        when:
        def calculatorService = new CalculatorService()

        then:
        calculatorService.sum(2, 3) == 5
    }
}
