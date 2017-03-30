package test.logics

import play.api.inject.guice.GuiceApplicationBuilder
import java.io.File

import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext


class Query01Spec extends PlaySpec with OneAppPerSuite
{
  override lazy implicit val app=new GuiceApplicationBuilder().in(new File(".")).build()
  /*
  class TestApplicationComponents(context:Context,overrides:Map[String,String]) extends BuiltInComponentsFromContext(context)
  {
    
    lazy val query01=null
    
  }
  */
  "QuerySpec" should
  {
    "" in
    {
      
      
      
      
    }
  }
}

