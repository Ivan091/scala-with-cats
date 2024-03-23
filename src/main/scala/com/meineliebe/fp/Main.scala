package com.meineliebe.fp
import com.meineliebe.fp.PrintableInstances.given

final case class Cat(name: String, age: Int, color: String)

object Cat {
  given Printable[Cat] with {
    override def format(cat: Cat): String = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }
}

trait Printable[A] {
  def format(x: A): String
}

object Printable {
  def format[A](x: A)(using P: Printable[A]): String = P.format(x)

  def print[A](x: A)(using P: Printable[A]): Unit = {
    println(P.format(x))
  }
}

object PrintableInstances {
  given Printable[Int] with {
    override def format(x: Int): String = x.toString
  }

  given Printable[String] with {
    override def format(x: String): String = x
  }
}

extension [A](x: A) {
  def format(using P: Printable[A]): String = Printable.format(x)
  def print(using P: Printable[A]): Unit = Printable.print(x)
}
