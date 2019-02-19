package com.emaginalabs.wecodeproperties

import io.kotlintest.specs.ShouldSpec

class FibonacciSpec : ShouldSpec() {

    fun fibonacci(n: Int): Long {
        tailrec fun fib_tail(n: Int, a: Long, b: Long): Long {
            return when (n) {
                0 -> a
                else -> fib_tail(n - 1, b, a + b)
            }
        }
        return fib_tail(n, 0, 1)
    }

    init {
        "Fibonacci of n" {
            should("keep the most important property") {
                // please, find the property and test it. The implementation of fibonacci is slow so you can check what happen with big numbers ;)
            }
        }
    }
}