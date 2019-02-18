package com.emaginalabs.wecodeproperties

import io.kotlintest.properties.forAll
import io.kotlintest.shouldNotBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.ShouldSpec

class PlayingWithLibrarySpec : ShouldSpec() {
    init {
        "Playing with the library" {
            should("add logs to know how it executes") {
                forAll { a: Int, b: Int ->
                    // write test the whatever property about the sum but add logs to know the value of the received numbers
                    true
                }
            }

            should("allow us to modify the number of executions") {
                // write a test in order to ensure the the number of executions
                // TIP: Check the paramters accepted by forAll to change the number of executions
            }

            should("make a test fail in order to see how shrink works") {
                val exception = shouldThrow<AssertionError> {
                    forAll { a: Int, b: Int ->
                        false
                    }
                }
                exception shouldNotBe null
            }

            should("be extremely slow when a generator is too restrictive") {
                // write a custom generator that is too restrictive to find enough values to run the tests.
                // Tip: Make your test execute just once in order to pass the test. Otherwise it'll last too much.
                // Here you'll find how to implemente a custom generator: https://github.com/kotlintest/kotlintest/blob/master/doc/reference.md#custom-generators. Pay attention to filter method to implement a restrictive generator.
            }

            should("not fail when a generator is limited but not restrictive") {
                // write a custom generator that only generate a very limited range of values.
                // Tip: You can use an already defined generator or just implement yours. I'll do mine :). Pay attention to map method to implement a non-restrictive generator.
            }
        }
    }
}