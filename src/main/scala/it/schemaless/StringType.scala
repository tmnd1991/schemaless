package it.schemaless

class StringType private () extends SchemalessType("String", "UTF-8 String")

object StringType extends StringType
