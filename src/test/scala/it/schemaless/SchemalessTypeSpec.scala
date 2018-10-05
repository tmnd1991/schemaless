package it.schemaless

import org.scalatest.{FlatSpec, Matchers}

class SchemalessTypeSpec extends FlatSpec with Matchers {
  "A single instance of StringType" should "exists" in {
    StringType should be theSameInstanceAs (StringType)
  }

  "Two RecordType with the same inner type" should "be equal" in {
    RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil) should be(
      RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil)
    )
  }

  "Two SeqType with the same inner type" should "be equal" in {
    SeqType(RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil)) should be(
      SeqType(RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil))
    )
  }

}
