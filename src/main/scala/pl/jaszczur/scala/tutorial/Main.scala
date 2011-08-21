package pl.jaszczur.scala.tutorial

class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc
  
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  override def toString(): String = "(" + x + ", " + y + ")";
}

object Main {
	def main(args : Array[String]) {
	  println("dupa")
	  val p = new Point(3, 4)
	  println("xxx: " + p.x)
	}
}