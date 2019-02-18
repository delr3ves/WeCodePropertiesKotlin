package com.emaginalabs.wecodeproperties

import io.kotlintest.*
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.ShouldSpec

class PlayingWithLibrarySpec : ShouldSpec() {
    init {
        "Playing with the library" {
            should("add logs to know how it executes") {
                forAll { a: Int, b: Int ->
                    println("Just executed the test with values [a: $a, b: $b]")
                    true
                }
            }

            should("allow us to modify the number of executions") {
                var executed = 0
                val expectedExecutions = 10
                forAll(iterations = expectedExecutions) { a: Int, b: Int ->
                    executed += 1
                    a + b == b + a
                }
                executed shouldBe expectedExecutions
            }

            should("make a test fail in order to see how shrink works") {
                val exception = shouldThrow<AssertionError> {
                    forAll { a: Int, b: Int ->
                        a < 5 || b < 7
                    }
                }
                exception shouldNotBe null
            }

            should("fail when a generator is too restrictive") {
                forAll(iterations = 1, gena = Gen.int().filter { it > 10 && it < 15 }) { a: Int ->
                    a > 10 && a < 15
                }
            }

            should("not fail when a generator is limited but not restrictive") {
                fun rangeGenerator(a: Int, b: Int): Gen<Int> = Gen.int().map {
                    val abs = Math.abs(it)
                    (abs % (b - a)) + a
                }
                forAll(rangeGenerator(11, 15)) { a: Int ->
                    a > 10 && a < 15
                }
            }
        }
    }
}