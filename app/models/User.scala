package models

import org.springframework.data.neo4j.annotation.{Indexed, GraphId, NodeEntity}
import org.springframework.data.neo4j.support.index.IndexType
import scala.reflect.{BeanProperty, BooleanBeanProperty}

@NodeEntity
class User {
  @GraphId
  var id: java.lang.Long = _

  @Indexed(indexName = "username", indexType = IndexType.FULLTEXT)
  var username: String = _

  override def toString = {
    "User %d %s".format(id, username)
  }
}