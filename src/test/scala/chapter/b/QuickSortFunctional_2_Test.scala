package chapter.b

import org.scalatest.FunSuite

class QuickSortFunctional_2_Test extends FunSuite {
  test("QuickSortFunctional_2.sort") {
    val arrayToSort = Array(77, 45, 88, 22)
    val arraySorted = QuickSortFunctional_2.sort(arrayToSort)
    assert(arraySorted === Array(22, 45, 77, 88))
  }
}
