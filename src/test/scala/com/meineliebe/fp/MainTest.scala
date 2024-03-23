package com.meineliebe.fp

import cats.syntax.all.toShow
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

final class MainTest extends AnyFreeSpec with Matchers {

  "Main" in {
    val cat = Cat("a", 2, "c")
    println {
      cat.show
    }
  }
}
