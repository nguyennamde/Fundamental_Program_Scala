name := "spark_etl"
version := "1.0"
scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
    "org.apache.logging.log4j" % "log4j-api" % "2.17.0",
    "org.apache.logging.log4j" % "log4j-core" % "2.17.0",
    "org.apache.spark" % "spark-core_2.12" % "3.4.1",
    "org.apache.spark" % "spark-sql_2.12" % "3.4.1",
    "com.google.code.gson" % "gson" % "2.8.9"

)

// sbt-assembly settings
assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*)                          => MergeStrategy.discard
    case PathList("git.properties")                             => MergeStrategy.first
    case "arrow-git.properties"                                 => MergeStrategy.first
    case "any.proto"                                            => MergeStrategy.first
    case "google/protobuf/any.proto"                            => MergeStrategy.discard
    case "google/protobuf/descriptor.proto"                     => MergeStrategy.discard
    case "google/protobuf/empty.proto"                          => MergeStrategy.discard
    case x if x.matches(".*FastHashMap.*.class")                => MergeStrategy.first
    case x if x.endsWith("FastHashMap.class")                   => MergeStrategy.discard 
    case x if x.endsWith("package-info.class")                  => MergeStrategy.discard 
    case x if x.endsWith("Inject.class")                        => MergeStrategy.discard 
    case x if x.endsWith("UnusedStubClass.class")               => MergeStrategy.discard  
    case x if x.endsWith("Named.class")                         => MergeStrategy.discard
    case x if x.endsWith("Provider.class")                      => MergeStrategy.discard 
    case x if x.endsWith("Scope.class")                         => MergeStrategy.discard     
    case x if x.endsWith("Qualifier.class")                     => MergeStrategy.discard 
    case x if x.endsWith("ArrayStack.class")                    => MergeStrategy.discard 
    case x if x.endsWith("BufferUnderflowException.class")      => MergeStrategy.discard 
    case x if x.endsWith("Invocation.class")                    => MergeStrategy.discard 
    case x if x.endsWith("Interceptor.class")                   => MergeStrategy.discard 
    case x if x.endsWith("Singleton.class")                     => MergeStrategy.discard     
    case x if x.endsWith("Advice.class")                        => MergeStrategy.discard     
    case x if x.endsWith("AspectException.class")               => MergeStrategy.discard 
    case x if x.endsWith("Joinpoint.class")                     => MergeStrategy.discard 
    case x if x.endsWith("Buffer.class")                        => MergeStrategy.discard 
    case x if x.endsWith("NoOpLog.class")                       => MergeStrategy.discard     
    case x if x.endsWith("AuthenticationType.class")            => MergeStrategy.discard 
    case x if x.endsWith("module-info.class")                   => MergeStrategy.discard 
    case x if x.endsWith("Log.class")                           => MergeStrategy.discard 
    case x if x.endsWith("LogConfigurationException.class")     => MergeStrategy.discard 
    case x if x.endsWith("LogFactory.class")                    => MergeStrategy.discard 
    case x if x.endsWith("SimpleLog.class")                     => MergeStrategy.discard 
    case x if x.endsWith("SimpleLog$1.class")                   => MergeStrategy.discard 

    case x =>
        val oldStrategy = (ThisBuild /assemblyMergeStrategy).value
        oldStrategy(x)
}


lazy val utils = (project in file("."))
    .settings(
        assembly / assemblyJarName := "sparketl123.jar"
    )

// Resolvers (optional)
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.typesafeRepo("releases")
)
