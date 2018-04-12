name := "machine-learning-productionizing"

version := "0.1"

scalaVersion := "2.12.4"

// For PMML
libraryDependencies += "org.jpmml" % "pmml-evaluator" % "1.4.1"
libraryDependencies += "org.jpmml" % "pmml-evaluator-extension" % "1.4.1"

// For H2O
libraryDependencies += "ai.h2o" % "h2o-genmodel" % "3.18.0.2"

