package it.schemaless

import shapeless.the

sealed trait Schema[A] {
  val name: String
  val description: String
}

object Schema {
  def apply[A: Schema]: Schema[A] = the[Schema[A]]
}

class Primitive[A](override val name: String, override val description: String) extends Schema[A]

class Composite[A](override val name: String, override val description: String, fields: List[Column[_]])
    extends Schema[A] {

  val byName: Map[String, Column[_]] = fields.map(x => x.name -> x).toMap
  val byIndex: Map[Int, Column[_]] = fields.zipWithIndex.map(_.swap).toMap

  lazy val duplicated: String = fields
    .groupBy(_.name)
    .map {
      case (k, v) => (k, v.length, v.map(_.schema.name))
    }
    .filter(_._2 > 1)
    .map(x => (x._1, x._3.mkString("[", ", ", "]")))
    .mkString(", ")
  require(byName.size == fields.length, s"There are fields with the same name $duplicated")

  def apply[B](index: Int): Schema[B] = byIndex(index).asInstanceOf[Schema[B]]

  def apply[B](colName: String): Schema[B] = byName(colName).asInstanceOf[Schema[B]]
}
