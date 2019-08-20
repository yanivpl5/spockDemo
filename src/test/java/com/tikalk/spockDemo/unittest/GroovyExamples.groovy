package com.tikalk.spockDemo.unittest

import spock.lang.Specification

class GroovyExamples extends Specification {
    class Employee {
        String firstName
        String lastName
        int age
    }

    def "variables evaluation inside string"() {
        expect:
        def name = "yaniv"

        print "my name is: $name"
    }

    def "map based construction"() {
        expect:
        Employee trainee =
                new Employee(age:22, firstName: "Alice", lastName: "Olson")

        print(trainee.properties)
    }

    def "map creation in groovy"() {
        expect:
        Map<String,Integer> wordCounts = ["Hello":1, "Groovy":1, "World":2]

        print wordCounts
    }

    def "list creation in groovy"() {
        expect:
        List<String> races = ["Drazi", "Minbari", "Humans"]

        print races
    }

    def "list accessing in groovy"() {
        given:
        List<String> humanShips = ["Condor","Explorer"]

        expect:
        assert humanShips[0] == "Condor"
    }

    def "simple closure in groovy"() {
        expect:
        Closure simple = { int x -> return x * 2}

        print "simple(1): " + simple(1)
    }

    def "using dynamic object in groovy with Expando"() {
        given:
        Expando user = new Expando()
        user.name = "yaniv"
        user.role = "developer"

        expect:
        print user.properties
    }
}