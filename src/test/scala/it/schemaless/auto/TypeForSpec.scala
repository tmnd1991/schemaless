package it.schemaless.auto
import it.schemaless.auto.mock.Person
import it.schemaless.record.RecordField
import it.schemaless.{RecordType, StringType}
import org.scalatest.{FlatSpec, Matchers}
import shapeless.::
import shapeless.labelled.KeyTag

class TypeForSpec extends FlatSpec with Matchers {
  it should "generate a correct schema for Person" in {

    val personSchema = TypeFor[Person]
    personSchema.schemalessType should be(
      RecordType(RecordField("name", StringType) :: RecordField("surname", StringType) :: Nil)
    )
  }

}
