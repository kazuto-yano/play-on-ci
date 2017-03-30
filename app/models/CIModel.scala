package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object CIModel extends {
  val profile = slick.driver.MySQLDriver
} with CIModel

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait CIModel {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Hello.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Hello
   *  @param email Database column email SqlType(VARCHAR), Length(500,true)
   *  @param name Database column name SqlType(VARCHAR), Length(100,true)
   *  @param password Database column password SqlType(VARCHAR), Length(100,true)
   *  @param age Database column age SqlType(INT), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey */
  case class HelloRow(email: String, name: String, password: String, age: Option[Int] = None, address: Option[String] = None, id: Option[Int] = None)
  /** GetResult implicit for fetching HelloRow objects using plain SQL queries */
  implicit def GetResultHelloRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[HelloRow] = GR{
    prs => import prs._
    val r = (<<?[Int], <<[String], <<[String], <<[String], <<?[Int], <<?[String])
    import r._
    HelloRow.tupled((_2, _3, _4, _5, _6, _1)) // putting AutoInc last
  }
  /** Table description of table hello. Objects of this class serve as prototypes for rows in queries. */
  class Hello(_tableTag: Tag) extends Table[HelloRow](_tableTag, "hello") {
    def * = (email, name, password, age, address, Rep.Some(id)) <> (HelloRow.tupled, HelloRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(email), Rep.Some(name), Rep.Some(password), age, address, Rep.Some(id)).shaped.<>({r=>import r._; _1.map(_=> HelloRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column email SqlType(VARCHAR), Length(500,true) */
    val email: Rep[String] = column[String]("email", O.Length(500,varying=true))
    /** Database column name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column password SqlType(VARCHAR), Length(100,true) */
    val password: Rep[String] = column[String]("password", O.Length(100,varying=true))
    /** Database column age SqlType(INT), Default(None) */
    val age: Rep[Option[Int]] = column[Option[Int]]("age", O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(1000,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(1000,varying=true), O.Default(None))
    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table Hello */
  lazy val Hello = new TableQuery(tag => new Hello(tag))
}
