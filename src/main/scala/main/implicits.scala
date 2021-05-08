package main

object implicits {
  implicit class TypeSafeConfigImpl(config: com.typesafe.config.Config) {
    def get[A](name: java.lang.String) = config.getAnyRef(name).asInstanceOf[A]
  }
}
