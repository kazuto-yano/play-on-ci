package logics

import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import scala.concurrent.Future
import models.CIModel
import javax.inject.Singleton

@Singleton
class Query01  @Inject()(db:DatabaseConfigProvider)
{
  
  val dbConfig=db.get[JdbcProfile]
  
  import slick.driver.MySQLDriver.api._
  
  def queryALL():Future[Seq[CIModel.HelloRow]]={
    val result = CIModel.Hello.result
    dbConfig.db.run(result)
  }
  
}