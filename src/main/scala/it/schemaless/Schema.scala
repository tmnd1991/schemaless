package it.schemaless

sealed trait Schema[A] {
  val name: String
  val description: String
}

object Schema {
  def apply[A: Schema]: Schema[A] = implicitly[Schema[A]]
}

class Primitive[A](override val name: String, override val description: String) extends Schema[A]

class Composite[A](override val name: String, override val description: String) extends Schema[A]
