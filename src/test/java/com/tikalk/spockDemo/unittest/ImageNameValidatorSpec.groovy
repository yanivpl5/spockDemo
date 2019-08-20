package com.tikalk.spockDemo.unittest

import com.tikalk.spockDemo.service.ImageExtensionCheck
import com.tikalk.spockDemo.service.ImageNameValidator
import spock.lang.Specification
import spock.lang.Unroll

class ImageNameValidatorSpec  extends Specification {
    def "Valid images are PNG and JPEG files"() {
        given: "an image extension checker"
        ImageNameValidator validator = new ImageNameValidator()

        expect: "that only valid filenames are accepted"
        validator.isValidImageExtension(pictureFile) == validPicture

        where: "sample image names are"
        pictureFile         ||  validPicture
        "scenery.jpg"       ||  true
        "house.jpeg"        ||  true
        "car.png"           ||  true
        "sky.tiff"          ||  false
        "dance_bunny.gif"   ||  false
    }

    def "Valid images are PNG and JPEG files extended"() {
        given: "an image extension checker"
        ImageNameValidator validator = new ImageNameValidator()

        when: "an image is checked"
        ImageExtensionCheck imageExtensionCheck = validator.validateImageExtension(pictureFile)

        then:"expect that only valid filenames are accepted"
        imageExtensionCheck.result == validPicture
        imageExtensionCheck.errorCode == error
        imageExtensionCheck.errorDescription == description

        where: "sample image names are"
        pictureFile         ||  validPicture    |   error       |  description
        "scenery.jpg"       ||  true            |   ""          |   ""
        "house.jpeg"        ||  true            |   ""          |   ""
        "car.png"           ||  true            |   ""          |   ""
        "sky.tiff"          ||  false           |   "ERROR002"  |   "Tiff files are not supported"
        "dance_bunny.gif"   ||  false           |   "ERROR999"  |   "Unsupported file type"
    }

    @Unroll("Valid images for #pictureFile")
    def "Valid images are PNG and JPEG files extended with Unroll"() {
        given: "an image extension checker"
        ImageNameValidator validator = new ImageNameValidator()

        when: "an image is checked"
        ImageExtensionCheck imageExtensionCheck = validator.validateImageExtension(pictureFile)

        then:"expect that only valid filenames are accepted"
        imageExtensionCheck.result == validPicture
        imageExtensionCheck.errorCode == error
        imageExtensionCheck.errorDescription == description

        where: "sample image names are"
        pictureFile         ||  validPicture    |   error       |  description
        "scenery.jpg"       ||  true            |   ""          |   ""
        "house.jpeg"        ||  true            |   ""          |   ""
        "car.png"           ||  true            |   ""          |   ""
        "sky.tiff"          ||  false           |   "ERROR002"  |   "Tiff files are not supported"
        "dance_bunny.gif"   ||  false           |   "ERROR999"  |   "Unsupported file type"
    }
}
