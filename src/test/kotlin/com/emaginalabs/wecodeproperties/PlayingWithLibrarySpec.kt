package com.emaginalabs.wecodeproperties

import io.kotlintest.fail
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

class PlayingWithLibrarySpec : ShouldSpec() {
    init {
        "Playing with the library" {
            should("add logs to know how it executes") {
                forAll { a: Int, b: Int ->
                    //write test the whatever property about the sum but add logs to know the value of the received numbers
                    true
                }
            }

            should("allow us to modify the number of executions") {
                //write a test in order to ensure the the number of executions
                // Here, you'll find how to change the number of success executions: https://stackoverflow.com/a/38706052
            }

            should("make a test fail in order to see how shrink works") {
                var failed = false
                try {
                    forAll { a: Int, b: Int ->
                        //write a test that sometimes fail and add traces in order to know how the library tries to give you a clue about the failing data
                        fail("Just fail")
                    }
                } catch (e: AssertionError) {
                    failed = true
                }
                failed shouldBe true
            }

            should("fail when a generator is too restrictive") {
                //write a custom generator that is too restrictive to find enough values to run the tests.
                //Tip: You can capture the error the same way the previous test :)
            }

            should("fail when a generator is limited but not restrictive") {
                //write a custom generator that only generate a very limited range of values.
                //Tip: You can use an already defined generator or just implement yours. I'll do mine :).
            }
        }
    }
}