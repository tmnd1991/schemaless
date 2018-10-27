package it.schemaless

class OptionType private (private val innerType: SchemalessType)
    extends SchemalessType(s"Option[${innerType.name}]", s"Option of ${innerType.name}") {

  override def equals(obj: Any): Boolean = {
    obj match {
      case other: OptionType => other.innerType == innerType
      case _: Any => false
    }
  }

  override def hashCode(): Int = innerType.hashCode()
}

object OptionType {
  def apply(innerType: SchemalessType): OptionType = new OptionType(innerType)
}
