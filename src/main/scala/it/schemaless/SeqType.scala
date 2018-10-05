package it.schemaless

class SeqType private (private val innerType: SchemalessType) extends SchemalessType {

  override def equals(obj: Any): Boolean = {
    obj match {
      case other: SeqType => other.innerType == innerType
      case _: Any => false
    }
  }

  override def hashCode(): Int = innerType.hashCode()

  override val name: String = s"Seq[${innerType.name}]"
  override val description: String = s"Sequence of ${innerType.name}"
}

object SeqType {
  def apply(innerType: SchemalessType): SeqType = new SeqType(innerType)
}
