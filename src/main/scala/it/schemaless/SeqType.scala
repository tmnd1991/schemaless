package it.schemaless

class SeqType private (private val innerType: SchemalessType)
    extends SchemalessType(
      s"Seq[${innerType.name}]",
      s"Sequence of ${innerType.name}"
    ) {

  override def equals(obj: Any): Boolean = {
    obj match {
      case other: SeqType => other.innerType == innerType
      case _: Any => false
    }
  }

  override def hashCode(): Int = innerType.hashCode()
}

object SeqType {
  def apply(innerType: SchemalessType): SeqType = new SeqType(innerType)
}
