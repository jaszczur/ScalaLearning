package pl.jaszczur.scala.tutorial

@SerialVersionUID(1)
class Person(val name : String, val email : String) extends Serializable {
  override def toString() = name + " <" + email + ">"
}