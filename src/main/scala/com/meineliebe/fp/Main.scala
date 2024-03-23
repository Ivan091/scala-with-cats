package com.meineliebe.fp
import cats.Show

final case class Cat(name: String, age: Int, color: String)

object Cat {
  given Show[Cat] = Show.show[Cat]{cat => cat.toString}
}
