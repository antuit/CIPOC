/***********editing from STS
  * Created by hrishikesh.kshatriya on 7/12/2017.
  */
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Row
import java.security.MessageDigest
import org.apache.spark.sql.Dataset
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import scala.reflect.runtime.universe
import java.util.Calendar
import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.functions.lit
import org.apache.spark.sql._
import org.apache.spark.sql.hive._

object cipoc {
  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setAppName("CIPOC Test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
    import hiveContext.implicits._
    val sanSource = hiveContext.read.format("jdbc").
    option("url", "jdbc:postgresql://10.0.0.8:5432/postgrescommon").
    option("jdbc_driver_library" , "postgresql-9.4-1201-jdbc41.jar").
    option("driver", "org.postgresql.Driver").
    option("dbtable", "company").
    option("user", "postgrescommon").
    option("password", "postgrescommon").load()
    sanSource.registerTempTable("sourceData")
    hiveContext.sql("SELECT COUNT(*) as count_before from  cipoc.sample")    
    hiveContext.sql("INSERT INTO TABLE cipoc.sample SELECT * FROM sourceData")
    hiveContext.sql("SELECT COUNT(*) as count_before from  cipoc.sample")


  }


}
