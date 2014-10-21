package controllers

import javax.inject.{Singleton, Inject, Named}

import models.{Person, PersonRepository}
import play.api.mvc._

@Named
@Singleton
class Application extends Controller{

  @Inject var personRepository: PersonRepository = _

  def index = Action {
    val person: Person = new Person
    person.setFirstname("Bruce")
    person.setSurname("Smith")
    val savedPerson: Person = personRepository.save(person)
    val retrievedPerson: Person = personRepository.findOne(savedPerson.getId)
    Ok(views.html.index.render("Found id: " + retrievedPerson.getId + " of person/people"))
  }

  def this(repo: PersonRepository) {
    this()
    personRepository = repo
  }
}