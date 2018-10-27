package it.schemaless.auto
import it.schemaless.{RecordType, SchemalessType}
import shapeless.the

import scala.annotation.implicitNotFound

class TypeFor[A](val schemalessType: SchemalessType)

class RecordTypeFor[A](override val schemalessType: RecordType) extends TypeFor[A](schemalessType)

object TypeFor {
  @implicitNotFound(msg = "Implicit not found for type ${A}")
  def apply[A: TypeFor]: TypeFor[A] = the[TypeFor[A]]
}
