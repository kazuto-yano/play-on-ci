package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import logics.Query01
import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() (query01:Query01)(implicit ec:ExecutionContext) extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action.async {request=>
    
    query01.queryALL().map{
      seq=>
      Ok(views.html.index(seq))
    }
    
    
  }

}

