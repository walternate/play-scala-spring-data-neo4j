package models

import org.springframework.data.neo4j.annotation._
import org.springframework.data.neo4j.support.index.IndexType
import org.neo4j.graphdb.Direction

@NodeEntity
class Movie {

  @GraphId
  var id: java.lang.Long = _

  @Indexed(indexName = "search", indexType = IndexType.FULLTEXT)
  var title: String = _

  var director: Person = _

  @RelatedTo(`type` = "ACTS_IN", direction = Direction.INCOMING )
  var actors :Set[Person] = _

  @RelatedToVia(`type` = "RATED")
  var ratings: Iterable[Rating] = _

  @Query("start movie=node({self}) match movie-->genre<--similar return similar")
  var similarMovies: Iterable[Movie] = _
}