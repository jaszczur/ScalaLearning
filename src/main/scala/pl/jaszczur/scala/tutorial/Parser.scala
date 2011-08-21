package pl.jaszczur.scala.tutorial
import java.io.InputStream

class Parser {

  def parse(input: String)(callback: (Person => Unit)) {
    input.split(",").foreach(parsePerson(_, callback))
  }

  private def parsePerson(str: String, callback: (Person => Unit)) {

    if (!str.trim().isEmpty()) {
      val splitted = str.split("<")
      
      personFromArray(splitted) match {
        case Some(p) => callback(p)
        case None => println("could not convert: " + str)
      }
    }
  }

  def asList(input: String): List[Person] = {
    var result: List[Person] = Nil

    parse(input) { p: Person => result ::= p }

    return result.reverse
  }
  
  private def personFromArray(splitted: Array[String]): Option[Person] = {
    splitted.length match {
        case 1 =>
          val email = splitted(0).trim()
          Some(new Person("", email))
        case 2 =>
          val name = splitted(0).trim()
          val email = splitted(1).substring(0, splitted(1).length() - 1)
          Some(new Person(name, email))
        case _ => None
      }
  }
}