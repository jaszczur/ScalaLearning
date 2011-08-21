package pl.jaszczur.scala.tutorial
import java.io.File

class Message(val title : String, val content : String, val attachments : List[File]) {
  def this(title : String, content : String) = this(title, content, Nil)
}
