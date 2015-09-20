package repositories

import scala.concurrent.Future

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}

import com.google.inject.{ImplementedBy, Inject}
import com.google.inject.name.Named
import models.{Company, CompanyModel}
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

@ImplementedBy(classOf[CompanyRepository])
trait CompanyRepositoryLike extends HasDatabaseConfig[JdbcProfile] {
  def findAll: Future[Seq[CompanyModel]]
}

class CompanyRepository @Inject() (@Named("master-database") dbName: String)
  extends CompanyRepositoryLike {

  import play.api.Play.current
  import driver.api._

  override protected val dbConfig: DatabaseConfig[JdbcProfile] =
    DatabaseConfigProvider.get[JdbcProfile](dbName)

  override def findAll: Future[Seq[CompanyModel]] = {
    db.run {
      Company.CompanyTableQuery.result
    }
  }
}
