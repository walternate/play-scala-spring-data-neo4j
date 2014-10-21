import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.data.neo4j.config.{JtaTransactionManagerFactoryBean, Neo4jConfiguration, EnableNeo4jRepositories}
import org.springframework.data.neo4j.support.Neo4jTemplate
import org.springframework.scala.context.function.FunctionalConfiguration


@Configuration
@EnableNeo4jRepositories(Array("models"))
class ApplicationConfiguration extends Neo4jConfiguration {
  private final val DB_PATH: String = "C:\\Users\\Ramiro Calle\\Documents\\Neo4j\\default.graphdb.bak"
  val gds = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH)

  @Bean
  def graphDatabaseService: GraphDatabaseService = gds

  @Bean
  override def neo4jTemplate =  new Neo4jTemplate(gds)

  @Bean(name = Array("neo4jTransactionManager", "transactionManager"))
  @Qualifier("neo4jTransactionManager")
  override def neo4jTransactionManager() = new JtaTransactionManagerFactoryBean(gds).getObject()

}

//@Configuration
//@EnableNeo4jRepositories(Array("models"))
//class ApplicationConfiguration extends FunctionalConfiguration { //Neo4jConfiguration with
//  private final val DB_PATH: String = "C:\\Users\\Ramiro Calle\\Documents\\Neo4j\\default.graphdb.bak"
//
//  val gds = bean(name = "graphDatabaseService") {
//    new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH)
//  }
//
//  bean(name = "neo4jTemplate"){
//    new Neo4jTemplate(gds())
//  }
//
//  bean(name = "neo4jTransactionManager", aliases = Seq("transactionManager")) {
//    new JtaTransactionManagerFactoryBean(gds()).getObject()
//  }
//
//}
