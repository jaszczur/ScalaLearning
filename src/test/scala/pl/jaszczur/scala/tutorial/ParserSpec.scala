package pl.jaszczur.scala.tutorial
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ParserSpec extends Spec with ShouldMatchers {

  describe("A Parser") {

    describe("parse") {
      it("should parse one person") {
        var result: Person = null
        var count = 0

        val instance = new Parser
        val input = "Piotr Jaszczyk <jaszczur@qq.com>"
        instance.parse(input) { p: Person => result = p; count += 1 }

        result should not be (null)
        count should equal(1)

        result.name should equal("Piotr Jaszczyk")
        result.email should equal("jaszczur@qq.com")
      }

      it("should parse two persons") {
        var result: List[Person] = Nil

        val instance = new Parser
        val input = "Piotr Jaszczyk <jaszczur@qq.com>, Wałek Wałecki <walek@interia.pl>"
        instance.parse(input) { p: Person => result ::= p }

        result = result.reverse
        result.size should be(2)

        result(0).name should equal("Piotr Jaszczyk")
        result(0).email should equal("jaszczur@qq.com")

        result(1).name should equal("Wałek Wałecki")
        result(1).email should equal("walek@interia.pl")
      }
      
      it("should parse string when there are emails only (without names)") {
        
        var result: List[Person] = Nil

        val instance = new Parser
        val input = "jaszczur@qq.com, Wałek Wałecki <walek@interia.pl>"
        instance.parse(input) { p: Person => result ::= p }

        result = result.reverse
        result.size should be(2)

        result(0).name should equal("")
        result(0).email should equal("jaszczur@qq.com")

        result(1).name should equal("Wałek Wałecki")
        result(1).email should equal("walek@interia.pl")
      }
    }

    describe("asList") {
      it("should return list of people") {
        val instance = new Parser
        val input = "Piotr Jaszczyk <jaszczur@qq.com>, Wałek Wałecki <walek@interia.pl>"
        val result = instance.asList(input)

        result.size should be(2)

        result(0).name should equal("Piotr Jaszczyk")
        result(0).email should equal("jaszczur@qq.com")

        result(1).name should equal("Wałek Wałecki")
        result(1).email should equal("walek@interia.pl")
      }
      
      
      it("should return list of people even if it ends with a comma and a space") {
        val instance = new Parser
        val input = "Piotr Jaszczyk <jaszczur@qq.com>, Wałek Wałecki <walek@interia.pl>, "
        val result = instance.asList(input)

        result.size should be(2)

        result(0).name should equal("Piotr Jaszczyk")
        result(0).email should equal("jaszczur@qq.com")

        result(1).name should equal("Wałek Wałecki")
        result(1).email should equal("walek@interia.pl")
      }

    }
  }
}