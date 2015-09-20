package services

import scala.concurrent.Future

import com.google.inject.{Inject, ImplementedBy}
import models.ComputerModel
import repositories.ComputerRepositoryLike

@ImplementedBy(classOf[ComputerService])
trait ComputerServiceLike {
  def findAll: Future[Seq[ComputerModel]]
}

class ComputerService @Inject() (computerRepository: ComputerRepositoryLike)
  extends ComputerServiceLike {

  override def findAll: Future[Seq[ComputerModel]] = {
    computerRepository.findAll
  }
}
