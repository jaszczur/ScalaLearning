package pl.jaszczur.scala.tutorial

import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import Person._

@RunWith(classOf[JUnitRunner])
class EmailServiceSpec extends Spec with ShouldMatchers {
  describe("Email service") {
    describe("single send") {
      val msg = new Message("Important message", "Just kidding")
      val recipment = "John Theonlyone <john@qq.com>".getPerson
      
      EmailService.send(msg, recipment.get)
    }
    
    describe("multi send") {
      val msg = new Message("Important message", "Just kidding")
      val recipments = "jaszczur <jaszczur@qq.com>, zenek <zenek@gmail.com>, wiesiek <w86@msn.com>".getPeople
      
      EmailService.send(msg, recipments)
    }
  }
}