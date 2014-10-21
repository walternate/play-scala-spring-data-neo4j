package models

import javax.inject.Named
import javax.inject.Singleton

import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.GraphRepository

@Named
@Singleton
trait MovieRepository extends GraphRepository[Movie]{ //extends CrudRepository<Person, Long>
    @Query("start movie={0} match m<-[rating:RATED]-user return rating")
    def getRatings(movie: Movie): Iterable[Rating]

    // Co-Actors
    //def findByActorsMoviesActorName(name: String) : Iterable[Person]

}
