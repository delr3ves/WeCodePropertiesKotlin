package com.emaginalabs.wecodeproperties

import io.kotlintest.specs.ShouldSpec
import io.kotlintest.shouldBe

class WeCodePlaygroundSpec : ShouldSpec() {

    fun sum(a: Int, b: Int): Int = a + b

    init {
        "Sum properties" {
            should("keep the associative property") {
                //TODO test the associative property
            }
            should("keep the commutative property") {
                //TODO test the commutative property
            }
            should("have an identity value") {
                //TODO test the identity property
            }
            should("actually sum a couple numbers") {
                //TODO test the sum
            }
        }
    }
}