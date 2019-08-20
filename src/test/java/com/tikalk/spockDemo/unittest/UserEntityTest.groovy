package com.tikalk.spockDemo.unittest

import com.tikalk.spockDemo.domain.User
import com.tikalk.spockDemo.service.UserService
import spock.lang.Specification

class UserEntityTest extends Specification {
    def "test user creation successfully"() {
        given:"New user entity is given"
        def user = new User(username: "james", firstName: "James", lastName: "Strachan", description: "founder")
        def userService = new UserService()

        when:"Invoking user creation with user entity"
        def newUser = userService.createUser(user)

        then:"Check that the username matches"
        newUser.username == user.username
    }

    def "test user creation successfully with cleanup"() {
        given:"New user entity is given"
        def user = new User(username: "james", firstName: "James", lastName: "Strachan", description: "founder")
        def userService = new UserService()

        when:"Invoking user creation with user entity"
        def newUser = userService.createUser(user)

        then:"Check that the username matches"
        newUser.username == user.username

        cleanup:
        userService.close()
    }

    def "test user creation successfully with and"() {
        given:"New user entity is given"
        def user = new User(username: "james", firstName: "James", lastName: "Strachan", description: "founder")

        and: "UserService is created"
        def userService = new UserService()

        when:"Invoking user creation with user entity"
        def newUser = userService.createUser(user)

        then:"Check that the username matches"
        newUser.username == user.username
    }
}
