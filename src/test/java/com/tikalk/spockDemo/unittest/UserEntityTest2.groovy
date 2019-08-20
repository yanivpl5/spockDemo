package com.tikalk.spockDemo.unittest

import com.tikalk.spockDemo.domain.User
import com.tikalk.spockDemo.service.UserService
import spock.lang.Specification

class UserEntityTest2 extends Specification {
    def userService
    def user

    def setup() {
        userService = new UserService()
        user = new User(username: "james", firstName: "James", lastName: "Strachan", description: "founder")
    }

    def "test user creation successfully"() {
        when:"Invoking user creation with user entity"
        def newUser = userService.createUser(user)

        then:"Check that the username matches"
        newUser.username == user.username
    }

    def cleanup() {
        userService.close()
    }
}
