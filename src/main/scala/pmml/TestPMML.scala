package pmml

import java.io.FileInputStream

import model.BostonHousingFeatureSet
import org.jpmml.evaluator.mining.MiningModelEvaluator
import org.jpmml.model.PMMLUtil

import scala.util.{Failure, Success}

/**
  * This example showcases how ML models built by data scientists in sklearn
  * exported as pmml's can be reused in real scala production code.
  */
object TestPMML extends App {

  // 5.69175   0.00  18.100  0  0.5830  6.1140  79.80  3.5459  24  666.0  20.20 392.68  14.98
  // The actual target is 19100, the rdf in python predicted 18640
  val testFeatures = new BostonHousingFeatureSet(
    5.69175F,
    0.00F,
    18.100F,
    0,
    0.5830F,
    6.1140F,
    79.80F,
    3.5459F,
    24,
    666.0F,
    20.20F,
    392.68F,
    14.98F
  ) with PMMLSupport

  // Read the model from resource folder
  val model = new FileInputStream(getClass.getResource("Bosten_Housing_Model_RDF.pmml").getPath)

  // Get the evaluator
  val tryEvaluator = cleanly(model)(_.close) { in =>

    val pmml = PMMLUtil.unmarshal(in)
    val evaluator = new MiningModelEvaluator(pmml) // The RandomForestModel was saved as a MiningModel

    evaluator.verify() // Evaluate the pmml before using it!
    evaluator
  }

  val tryPrediction = for {
    evaluator <- tryEvaluator
    predictionMap = evaluator.evaluate(testFeatures.toPMMLArgumentMap)
    prediction = predictionMap.get(evaluator.getTargetFieldName).asInstanceOf[Double]
  } yield prediction

  tryPrediction match {
    case Success(prediction) => println(s"Prediction: $prediction")
    case Failure(ex) => println(s"Something went wrong: ${ex.getMessage}")
  }
}


