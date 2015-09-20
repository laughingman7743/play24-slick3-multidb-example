package services

import scala.concurrent.Future

import com.google.inject.{Inject, ImplementedBy}
import models.CompanyModel
import repositories.CompanyRepositoryLike

@ImplementedBy(classOf[CompanyService])
trait CompanyServiceLike {
  def findAll: Future[Seq[CompanyModel]]
}

class CompanyService @Inject() (companyRepository: CompanyRepositoryLike)
  extends CompanyServiceLike {

  override def findAll: Future[Seq[CompanyModel]] = {
    companyRepository.findAll
  }
}
