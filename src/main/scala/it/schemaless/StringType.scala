package it.schemaless

class StringType private () extends SchemalessType {
  override val name: String = "String"
  override val description: String = "UTF-8 String"
}

object StringType extends StringType
