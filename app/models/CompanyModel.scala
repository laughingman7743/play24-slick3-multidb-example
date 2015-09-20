package models

import play.api.libs.json.Json

import slick.driver.PostgresDriver.profile.api._
import slick.lifted.Rep

case class CompanyModel(id: Int, name: String)

class Company(tag: Tag) extends Table[CompanyModel](tag, "companies") {
  val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
  val name: Rep[String] = column[String]("name")

  def * = (id, name) <> (CompanyModel.tupled, CompanyModel.unapply)
}

object Company {
  lazy val CompanyTableQuery: TableQuery[Company] = new TableQuery(tag => new Company(tag))
  implicit val companyModelWrites = Json.writes[CompanyModel]
  implicit val companyModelReads = Json.reads[CompanyModel]
}
