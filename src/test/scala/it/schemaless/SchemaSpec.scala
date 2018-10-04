package it.schemaless

import java.util.UUID

import org.scalatest.{FlatSpec, Matchers}

class SchemaSpec extends FlatSpec with Matchers {
  "All the supported primitive typeclasses" should "be summoned correctly" in {
    Schema[Int].name should be("Int")
    Schema[Long].name should be("Long")
    Schema[Char].name should be("Char")
    Schema[String].name should be("String")
    Schema[Float].name should be("Float")
    Schema[Double].name should be("Double")
    Schema[UUID].name should be("UUID")
  }

  "Option typeclass of each type" should "be summoned correctly" in {
    Schema[Option[Int]].name should be("Option[Int]")
    Schema[Option[Long]].name should be("Option[Long]")
    Schema[Option[Char]].name should be("Option[Char]")
    Schema[Option[String]].name should be("Option[String]")
    Schema[Option[Float]].name should be("Option[Float]")
    Schema[Option[Double]].name should be("Option[Double]")
    Schema[Option[Option[Double]]].name should be("Option[Option[Double]]")

  }
}
