package it.schemaless

class RecordType private (private val fields: Array[RecordField]) extends SchemalessType {
  override val name: String = s"Record[${fields.map(_.name).mkString(", ")}]"
  override val description: String = "I'm Lazy, not gonna do it now"

  override def equals(obj: Any): Boolean = {
    obj match {
      case rt: RecordType =>
        rt.fields.sameElements(this.fields)
      case _ => super.equals(obj)
    }
  }

  override def hashCode(): Int = fields.hashCode()
}

object RecordType {
  def apply(fields: Seq[RecordField]): RecordType = new RecordType(fields.toArray)
}
