package pl.jaszczur.scala.tutorial

object EmailService {
	def send(msg : Message, person : Person) {
	  println("Sending message '" + msg.title + "' to " + person)
	}
	
	def send(msg : Message, people : List[Person]) {
	  people match {
	    case h::t => send(msg, h); send(msg, t)
	    case Nil => println("All messages sent")
	  }
	}
}