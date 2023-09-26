import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions.{lit, max}
object Ingestion{
    def main(args: Array[String]): Unit={

        val spark = SparkSession
        .builder
        .appName("Test Ingestion")
        .getOrCreate()

        val rdd = spark.sparkContext.textFile("hdfs://hadoop-master:9000/test/input.txt")

        rdd.saveAsTextFile("hdfs://hadoop-master:9000/test/output.txt")
        

    }
}