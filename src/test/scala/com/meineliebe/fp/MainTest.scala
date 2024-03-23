package com.meineliebe.fp

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

final class MainTest extends AnyFreeSpec with Matchers {

  "Main" in {
    val cat = Cat("Garfield", 41, "ginger and black")
    cat.print
    Printable.print(cat)
  }
}
