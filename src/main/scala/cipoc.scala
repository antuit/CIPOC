<<<<<<< HEAD
/***********editing from STS
=======
/************
>>>>>>> 44a30673d00511adb0a79df6859d268185f5af35
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
<<<<<<< HEAD
=======

import java.sql.DriverManager
import java.sql.Connection
>>>>>>> 44a30673d00511adb0a79df6859d268185f5af35

object cipoc {
 

def main(args: Array[String]): Unit = {

<<<<<<< HEAD
    val conf = new SparkConf().setAppName("CIPOC Test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
    import hiveContext.implicits._
    val sanSource = hiveContext.read.format("jdbc").
=======
    val conf = new SparkConf().setAppName("CIPOC Test").setMaster("local[*]") 
    val sc = new SparkContext(conf)
    val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
    import hiveContext.implicits._
                import org.apache.spark.sql.types._
                import org.apache.spark.sql.Row
                //val schema_string = "dummy1,dummy2"
                //val schema_rdd = StructType(schema_string.split(",").map(fieldName => StructField(fieldName, StringType, true)))
                //var sanSource = hiveContext.createDataFrame(sc.emptyRDD[Row], schema_rdd) 
                val sanSource = hiveContext.read.format("jdbc").
>>>>>>> 44a30673d00511adb0a79df6859d268185f5af35
    option("url", "jdbc:postgresql://10.0.0.8:5432/postgrescommon").
    option("jdbc_driver_library" , "postgresql-9.4-1201-jdbc41.jar").
    option("driver", "org.postgresql.Driver").
    option("dbtable", "company").
    option("user", "postgrescommon").
<<<<<<< HEAD
    option("password", "postgrescommon").load()
    sanSource.registerTempTable("sourceData")
    hiveContext.sql("INSERT INTO TABLE cipoc.sample SELECT * FROM sourceData")

  }


}
=======
    option("password", "postgrescommon").load() 
                sanSource.registerTempTable("sourceData")
    hiveContext.sql("INSERT INTO TABLE cipoc.sample SELECT * FROM sourceData")
                
  }
  
  def getSrcConnection()  = {
                val driver = "org.postgresql.Driver"
    val url = "jdbc:postgresql://10.0.0.8:5432/postgrescommon"
    val username = "postgrescommon"
    val password = "postgrescommon1"
                var connection:Connection = null
                try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
	if(connection == null){
   		false
	} else{
   		true
	} 
        } catch {
      case e => e.printStackTrace
    }
}

}


>>>>>>> 44a30673d00511adb0a79df6859d268185f5af35
