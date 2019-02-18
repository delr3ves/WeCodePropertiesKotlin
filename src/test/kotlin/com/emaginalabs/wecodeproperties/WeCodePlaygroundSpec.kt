package com.emaginalabs.wecodeproperties

import io.kotlintest.specs.ShouldSpec
import io.kotlintest.shouldBe

class WeCodePlaygroundSpec : ShouldSpec() {

    init {
        "Test foo" {
            should("my first test") {
                true shouldBe true
            }
        }
    }
}