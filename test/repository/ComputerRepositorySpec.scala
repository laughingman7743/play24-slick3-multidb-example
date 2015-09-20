package repository

import play.api.test.{PlaySpecification, FakeApplication, WithApplication}

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import repositories.ComputerRepository
import util.TestHelper._

@RunWith(classOf[JUnitRunner])
class ComputerRepositorySpec extends PlaySpecification {

  "ComputerRepository" should {

    "work as expected" in new WithApplication(FakeApplication(additionalConfiguration = inMemorySlickDatabase())) {
      val repo = new ComputerRepository("test")
      val result = await(repo.findAll)
      result.size must equalTo(574)
    }
  }
}
