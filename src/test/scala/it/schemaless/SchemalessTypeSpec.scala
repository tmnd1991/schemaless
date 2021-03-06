package it.schemaless

import it.schemaless.record.RecordField
import org.scalatest.{FlatSpec, Matchers}

class SchemalessTypeSpec extends FlatSpec with Matchers {
  "A single instance of StringType" should "exists" in {
    StringType should be theSameInstanceAs (StringType)
  }

  // region equal

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

  "Two OptionType with the same inner type" should "be equal" in {
    OptionType(RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil)) should be(
      OptionType(RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil))
    )
  }

  // endregion

  // region not equal

  "Two RecordType with different inner type" should "not be equal" in {
    RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil) should not be
      RecordType(RecordField("nome", StringType) :: RecordField("altroNome", StringType) :: Nil)
  }

  "Two SeqType with different inner type" should "not be equal" in {
    SeqType(RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil)) should not be
      SeqType(RecordType(RecordField("nome", StringType) :: RecordField("altroNome", StringType) :: Nil))
  }

  "Two OptionType with different inner type" should "not be equal" in {
    OptionType(RecordType(RecordField("name", StringType) :: RecordField("otherName", StringType) :: Nil)) should not be
      OptionType(RecordType(RecordField("nome", StringType) :: RecordField("altroNome", StringType) :: Nil))
  }

  // endregion

}
