package it.schemaless
import it.schemaless.record.RecordField

class RecordType private (val fields: Seq[RecordField])
    extends SchemalessType(s"Record[${fields.map(_.name).mkString(", ")}]", "I'm Lazy, not gonna do it now") {

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
  def apply(fields: Seq[RecordField]): RecordType = new RecordType(fields)
}
