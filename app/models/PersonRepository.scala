package models

import org.springframework.data.neo4j.repository.GraphRepository

trait PersonRepository extends GraphRepository[Person]