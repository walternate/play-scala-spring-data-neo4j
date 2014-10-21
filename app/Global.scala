import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.neo4j.config.Neo4jConfiguration
import play.api._


/**
 * Application wide behaviour. We establish a Spring application context for the dependency injection system and
 * configure Spring Data.
 */
object Global extends GlobalSettings {
  /**
   * Declare the application context to be used - a Java annotation based application context requiring no XML.
   */
  //private final
 val ctx = new AnnotationConfigApplicationContext

  /**
   * Sync the context lifecycle with Play's.
   */
  override def onStart(app: Application) {
    Logger.info("Application has started")
    super.onStart(app)

    ctx.register(classOf[ApplicationConfiguration])

    ctx.scan("controllers", "models")
    try {
      ctx.refresh
    } catch {
      case e: IllegalStateException =>
        Logger.error(e.getMessage)
    }
    try {
      ctx.start
    } catch {
      case e: IllegalStateException =>
        Logger.error(e.getMessage)
    }
  }
  /**
   * Sync the context lifecycle with Play's.
   */
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
    ctx.close
    super.onStop(app)
  }

  /**
   * Controllers must be resolved through the application context. There is a special method of GlobalSettings
   * that we can override to resolve a given controller. This resolution is required by the Play router.
   */
  override def getControllerInstance[A](aClass: Class[A]): A = {
    return ctx.getBean(aClass)
  }

}

