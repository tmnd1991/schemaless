package it

package object schemaless {

  implicit object StringSchema extends Primitive[String]("String", "UTF-8 String")

  implicit object IntSchema extends Primitive[Int]("Int", "32bit signed integer")

  implicit object LongSchema extends Primitive[Long]("Long", "64bit signed integer")

  implicit object CharSchema extends Primitive[Char]("Char", "UTF-8 Character")

  implicit object FloatSchema extends Primitive[Float]("Float", "32bit floating point")

  implicit object DoubleSchema extends Primitive[Double]("Double", "64bit floating point")

  implicit def optionSchema[A: Schema]: Schema[Option[A]] = {
    val innerSchema = Schema[A]
    new Primitive[Option[A]](s"Option[${innerSchema.name}]", s"Optional of ${innerSchema.description}")
  }
}
