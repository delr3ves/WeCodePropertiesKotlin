package com.emaginalabs.wecodeproperties

import io.kotlintest.properties.forAll
import io.kotlintest.specs.ShouldSpec

class CollectionsSpec : ShouldSpec() {

    init {
        "Collections" {
            should("contain one more element after insertion") {
                forAll { list: List<Int>, a: Int ->
                    (list + a).contains(a)
                }
            }

            should("contain the inserted element") {
                forAll { list: List<Int>, a: Int ->
                    (list + a).size == list.size + 1
                }
            }

            should("have an element less after deletion") {
                forAll { list: List<Int>, a: Int ->
                    val numberOfAs = list.count { it == a }
                    val listIncludingA = list + a
                    val listWithNoAs = listIncludingA.filter { it != a }
                    listWithNoAs.size == list.size - numberOfAs
                }
            }

            should("not contain the removed element") {
                forAll { list: List<Int>, a: Int ->
                    val listIncludingA = list + a
                    val listWithNoAs = listIncludingA.filter { it != a }
                    !listWithNoAs.contains(a)
                }
            }

            should("contain the items of the two collections after a concatenation") {
                forAll { list1: List<String>, list2: List<String> ->
                    val joinedList = list1 + list2
                    joinedList.containsAll(list1) && joinedList.containsAll(list2)
                }
            }

            should("no duplicated elements when convert to a set") {
                forAll { list: List<Int> ->
                    val asSet = list.toSet()
                    val distinct = list.distinct()
                    asSet.containsAll(distinct) && distinct.containsAll(asSet)
                }
            }
        }
    }
}