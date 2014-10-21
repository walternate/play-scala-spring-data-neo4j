import models.{UserRepository, User}
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import org.springframework.transaction.annotation.Transactional

import play.api.test._
import play.api.test.Helpers._
import scala.collection.JavaConversions._
/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("of person/people")
    }


//    "insert into neo4j" in new WithApplication{
//      val mr = Global.ctx.getBean(classOf[MovieRepository])
//      val movie = new Movie()
//      movie.title = "matrix"
//      mr.save(movie)
//
//      for (u <- mr.findAll()) {
//        println("--------------------------")
//        println(u)
//        println("--------------------------")
//      }
//
//      mr.delete(movie)
//
//      for (u <- mr.findAll()) {
//        println("--------------------------")
//        println(u)
//        println("--------------------------")
//      }
//---------------------------------------
//      val ur = Global.ctx.getBean(classOf[UserRepository])
//      val u = new User
//      u.username = "foo:" + System.currentTimeMillis()
//      ur.save(u)
//
//      for (u <- ur.findAll()) println(u)
//    }

  }
}
