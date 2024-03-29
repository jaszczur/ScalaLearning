package pl.jaszczur.scala.tutorial

@SerialVersionUID(1)
class Person(val name: String, val email: String) extends Serializable {
  override def toString() = name + " <" + email + ">"
}

final class StringWithPerson(str: String) {
  
  implicit def getPeople() : List[Person] = new Parser().asList(str)
  
  implicit def getPerson() = {
    val list = new Parser().asList(str)
    list.size match {
      case 1 => list.headOption
      case _ => None
    }
  }
}

object Person {
  implicit def stringExtensions(input: String) = new StringWithPerson(input)
}
