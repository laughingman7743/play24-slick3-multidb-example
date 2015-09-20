package repositories

import scala.concurrent.Future

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}

import com.google.inject.name.Named
import com.google.inject.{Inject, ImplementedBy}
import models.{Computer, ComputerModel}
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

@ImplementedBy(classOf[ComputerRepository])
trait ComputerRepositoryLike extends HasDatabaseConfig[JdbcProfile] {
  def findAll: Future[Seq[ComputerModel]]
}

class ComputerRepository @Inject() (@Named("slave-database") dbName: String)
  extends ComputerRepositoryLike {

  import play.api.Play.current
  import driver.api._

  override protected val dbConfig: DatabaseConfig[JdbcProfile] =
    DatabaseConfigProvider.get[JdbcProfile](dbName)

  override def findAll: Future[Seq[ComputerModel]] = {
    db.run {
      Computer.ComputerTableQuery.result
    }
  }
}
