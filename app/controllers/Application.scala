package controllers

import scala.concurrent.ExecutionContext.Implicits.global

import play.api.libs.json.Json
import play.api.mvc._

import com.google.inject.Inject
import services.{CompanyServiceLike, ComputerServiceLike}

class Application @Inject() (companyService: CompanyServiceLike,
                             computerService: ComputerServiceLike)
  extends Controller {

  def company = Action.async {
    import models.Company._
    companyService.findAll.map { result =>
      Ok(Json.toJson(result))
    }
  }

  def computer = Action.async {
    import models.Computer._
    computerService.findAll.map { result =>
      Ok(Json.toJson(result))
    }
  }
}
