package com.tikalk.spockDemo.unittest

import com.tikalk.spockDemo.domain.User
import com.tikalk.spockDemo.repository.UserRepository
import com.tikalk.spockDemo.service.UserService
import spock.lang.Specification

class UserEntityTest3 extends Specification {
    def userService
    User user

    def setup() {
        user = new User(username: "james", firstName: "James", lastName: "Strachan", description: "founder")
    }

    def "test finding user by username with Stub"() {
        given:"set the username"
        def username = "james"

        and:"Create Stub for UserRepository to mock the real UserRepository"
        UserRepository userRepository = Stub(UserRepository)
        userRepository.findUserByUsername(username) >> user
        userService = new UserService(userRepository)

        when: "invoke find by username"
        User user = userService.findUserByUsername(username)

        then:"Check that the username matches the original"
        user.username == username
    }

    def "test finding user by username with leniently Stub"() {
        given:"set the username"
        def username = "james"

        and:"Create Stub for UserRepository to mock the real UserRepository"
        UserRepository userRepository = Stub(UserRepository)
        userRepository.findUserByUsername(_ as String) >> user
        userService = new UserService(userRepository)

        when: "invoke find by username"
        User user = userService.findUserByUsername(username)

        then:"Check that the username matches the original"
        user.username == username
    }

    def "test create user with Mock"() {
        given:"UserRepository is being mocked"
        UserRepository userRepository = Mock(UserRepository)
        userService = new UserService(userRepository)

        when:"creating new user"
        userService.createUser(user)

        then:"assert that the use is created in userRepository"
        1 * userRepository.createUser(user)
    }
}
