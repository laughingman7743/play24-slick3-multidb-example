package models

import play.api.libs.json.Json

import slick.driver.PostgresDriver.profile.api._
import slick.lifted.Rep

case class ComputerModel(id: Int, name: String, manufacturerId: Int)

class Computer(tag: Tag) extends Table[ComputerModel](tag, "computers") {
  val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
  val name: Rep[String] = column[String]("name")
  val manufacturerId: Rep[Int] = column[Int]("manufacturer_id")

  def * = (id, name, manufacturerId) <> (ComputerModel.tupled, ComputerModel.unapply)
}

object Computer {
  lazy val ComputerTableQuery: TableQuery[Computer] = new TableQuery(tag => new Computer(tag))
  implicit val computerModelWrites = Json.writes[ComputerModel]
  implicit val computerModelReads = Json.reads[ComputerModel]
}
