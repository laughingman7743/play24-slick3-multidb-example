package modules

import com.google.inject.AbstractModule
import com.google.inject.name.Names

class MasterTestDatabaseModule extends AbstractModule {
  override def configure() = {
    bind(classOf[String])
      .annotatedWith(Names.named("master-database"))
      .toInstance("test")
  }
}

class SlaveTestDatabaseModule extends AbstractModule {
  override def configure() = {
    bind(classOf[String])
      .annotatedWith(Names.named("slave-database"))
      .toInstance("test")
  }
}
