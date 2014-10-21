import org.specs2.mutable
import org.specs2.execute.{Result, AsResult}
import org.specs2.specification.{Scope, BeforeAfter, Fragments}
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericApplicationContext

/**
 * Created by Ramiro Calle on 21/10/2014.
 */
class ApplicationConfigurationSpec extends mutable.Specification with BeforeAfter {

  override def after = {}

  override def before = {}

  "this is the first example" in new WithAppConfig {

    applicationContext.getBean("application") must beNull

  }
}

class WithAppConfig extends Scope {
  val applicationContext = new AnnotationConfigApplicationContext()
//  applicationContext.register(classOf[ApplicationConfiguration])
//  applicationContext.scan("controllers", "models")
}
