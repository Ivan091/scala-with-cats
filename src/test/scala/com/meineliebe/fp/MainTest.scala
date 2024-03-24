package com.meineliebe.fp

import cats.implicits.catsSyntaxSemigroup
import cats.kernel.{Monoid, Semigroup}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import cats.syntax.all.toFoldableOps

object MainTest {
  given Monoid[Int] with {
    override def combine(x: Int, y: Int): Int = x + y
    override def empty: Int = 0
  }

  given[A](using M: Monoid[A]): Monoid[Option[A]] with {
    override def combine(x: Option[A], y: Option[A]): Option[A] = {
      x match {
        case Some(v1) => y match {
          case Some(v2) => Option(v1 |+| v2)
          case None => x
        }
        case None => y match {
          case Some(value) => Option(value)
          case None => Option.empty
        }
      }

    }

    override def empty: Option[A] = Option.empty
  }


}

final class MainTest extends AnyFreeSpec with Matchers {

  "Main" in {
    println {
      List.range(1, 10).map(Option.apply).combineAll
    }
  }
}
