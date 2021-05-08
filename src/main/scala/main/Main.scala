package main

import org.scalafans.Java
import implicits._

object Main extends App {
  println(new Java("Java").getName)

  val res = getClass.getResource("../application.properties")
  val props = new java.util.Properties()
  props.load(scala.io.Source.fromURL(res).bufferedReader)
  println(props.get("hbase_table_name"), props.get("hbase.zookeeper.quorum"))

  val config = com.typesafe.config.ConfigFactory.load("main/application.conf")
  val sparkBatch = config.getConfig("spark.test.batch")
  val (appName, nodeCount) = (sparkBatch.get[String]("app-name"), sparkBatch.get[Int]("nodes"))
  println(appName, nodeCount)
}