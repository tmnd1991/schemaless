package it.schemaless

class Column[A](val name: String, val schema: Schema[A])

object Column {
  def apply[A](name: String, schema: Schema[A]): Column[A] = new Column(name, schema)
}
