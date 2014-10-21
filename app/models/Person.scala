package models

import org.springframework.data.neo4j.annotation.{NodeEntity, GraphId}

import scala.beans.BeanProperty

@NodeEntity
class Person {

  @BeanProperty
  @GraphId
  var id: java.lang.Long = _

  @BeanProperty
  var firstname: String = _
  @BeanProperty
  var surname: String = _

  override def toString = {
    "Person %d %s %s".format(id, firstname, surname)
  }
}
