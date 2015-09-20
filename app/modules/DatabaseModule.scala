package modules

import com.google.inject.AbstractModule
import com.google.inject.name.Names

class MasterDatabaseModule extends AbstractModule {
  override def configure() = {
    bind(classOf[String])
    .annotatedWith(Names.named("master-database"))
    .toInstance("master")
  }
}

class SlaveDatabaseModule extends AbstractModule {
  override def configure() = {
    bind(classOf[String])
      .annotatedWith(Names.named("slave-database"))
      .toInstance("slave")
  }
}
