package it.schemaless

import it.schemaless.record.RecordField
import shapeless.labelled.FieldType
import shapeless.{::, HList, HNil, LabelledGeneric, Lazy, Witness}

package object auto {
  implicit object stringTypeFor extends TypeFor[String](StringType)

  implicit def optionTypeFor[A: TypeFor]: TypeFor[Option[A]] =
    new TypeFor[Option[A]](OptionType(TypeFor[A].schemalessType))

  implicit def seqTypeFor[A: TypeFor]: TypeFor[Seq[A]] = new TypeFor[Seq[A]](SeqType(TypeFor[A].schemalessType))

  //implicit def hNilTypeFor[N <: HNil]: TypeFor[N] = new TypeFor[N](RecordType(Nil))

  implicit def hlistTypeFor[K <: Symbol, H, T <: HList](
      implicit
      witness: Witness.Aux[K],
      hEncoder: Lazy[TypeFor[H]],
      tEncoder: RecordTypeFor[T]): TypeFor[FieldType[K, H] :: T] = {
    val fieldName = witness.value.name
    val schema = RecordType(RecordField(fieldName, hEncoder.value.schemalessType) +: tEncoder.schemalessType.fields)
    new TypeFor[FieldType[K, H] :: T](schema)
  }

  implicit def hlistLastTypeFor[K <: Symbol, H, T <: HNil](
      implicit
      witness: Witness.Aux[K],
      hEncoder: Lazy[TypeFor[H]]): TypeFor[FieldType[K, H] :: T] = {
    val fieldName = witness.value.name
    val schema = RecordType(RecordField(fieldName, hEncoder.value.schemalessType) :: Nil)
    new TypeFor[FieldType[K, H] :: T](schema)
  }

  implicit def genericObjectEncoder[A, R <: HList](
      implicit
      generic: LabelledGeneric.Aux[A, R],
      hEncoder: Lazy[TypeFor[A]]): TypeFor[R] = {
    new TypeFor[R](hEncoder.value.schemalessType)
  }
}
