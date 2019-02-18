package com.emaginalabs.wecodeproperties

import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class WeCodePlaygroundSpec : ShouldSpec() {

    fun sum(a: Int, b: Int): Int = a + b

    init {
        "Sum properties" {
            should("keep the associative property") {
                forAll { a: Int, b: Int, c: Int ->
                    sum(sum(a, b), c) == sum(a, sum(b, c))
                }
            }

            should("keep the commutative property") {
                forAll { a: Int, b: Int, c: Int ->
                    sum(a, b) == sum(b, a)
                }
            }

            should("have an identity value") {
                forAll { a: Int ->
                    sum(a, 0) == a
                }
            }

            val sumCases = table(
                headers("a", "b", "result"),
                row(1, 4, 5),
                row(4, 5, 9),
                row(0, 0, 0),
                row(-1, -5, -6),
                row(1, -5, -4),
                row(-5, 1, -4)
            )

            should("actually sum a couple numbers") {
                io.kotlintest.tables.forAll(sumCases) { a: Int, b: Int, expected: Int ->
                    a + b shouldBe expected
                }
            }
        }
    }
}