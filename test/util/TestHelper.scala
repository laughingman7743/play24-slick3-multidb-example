package util

object TestHelper {

  def inMemorySlickDatabase(name: String = "test",
                            options: Map[String, String] =
                            Map("MODE" -> "PostgreSQL",
                              "DB_CLOSE_DELAY" -> "-1",
                              "DATABASE_TO_UPPER" -> "false")): Map[String, String] = {
    val optionsForDbUrl = options.map { case (k, v) => k + "=" + v }.mkString(";", ";", "")

    Map(
      (s"slick.dbs.${name}.driver") -> "slick.driver.H2Driver$",
      (s"slick.dbs.${name}.db.driver") -> "org.h2.Driver",
      (s"slick.dbs.${name}.db.url") -> ("jdbc:h2:mem:play-test-" + scala.util.Random.nextInt + optionsForDbUrl),
      ("play.evolutions.enabled" -> "true"),
      (s"play.evolutions.slick.dbs.${name}.enabled" -> "true")
    )
  }
}
