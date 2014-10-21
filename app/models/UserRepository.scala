package models

import org.springframework.data.neo4j.repository.GraphRepository

trait UserRepository extends GraphRepository[User]