package pl.jaszczur.scala.tutorial

import Person._

object Main {
	def main(args : Array[String]) {
	  
		"jaszczur <jaszczur@qq.com>, zenek <zenek@gmail.com>, wiesiek <w86@msn.com>".getPeople foreach {p =>
		  println(p.name + "'s email: " + p.email)
		}
	}
}