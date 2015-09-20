package repository

import play.api.test.{FakeApplication, WithApplication, PlaySpecification}

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import repositories.CompanyRepository
import util.TestHelper._

@RunWith(classOf[JUnitRunner])
class CompanyRepositorySpec extends PlaySpecification {

  "CompanyRepository" should {

    "work as expected" in new WithApplication(FakeApplication(additionalConfiguration = inMemorySlickDatabase())) {
      val repo = new CompanyRepository("test")
      val result = await(repo.findAll)
      result.size must equalTo(42)
    }
  }
}
