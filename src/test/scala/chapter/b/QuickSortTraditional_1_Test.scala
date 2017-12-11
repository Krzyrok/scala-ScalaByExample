package chapter.b

import org.scalatest.FunSuite

class QuickSortTraditional_1_Test extends FunSuite {
  test("QuickSortTraditional_1.sort") {
    var arrayToSort = Array(77, 45, 88, 22)
    QuickSortTraditional_1.sort(arrayToSort)
    assert(arrayToSort === Array(22, 45, 77, 88))
  }
}
