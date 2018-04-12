package h2o


import hex.genmodel.MojoModel
import hex.genmodel.easy.EasyPredictModelWrapper
import model.BostonHousingFeatureSet

/**
  * This example showcases how ML models built by data scientists with H2O models be reused in real scala production code.
  */
object TestH2O extends App {

  // 5.69175   0.00  18.100  0  0.5830  6.1140  79.80  3.5459  24  666.0  20.20 392.68  14.98
  // The actual target is 19100, the rdf in python predicted 19386
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
  ) with H2OSupport

  // Read the model from resource folder
  val modelPath = getClass.getResource("Boston_Housing_Model_RDF_H2O.zip").getPath

  // Load the model into memory
  val model = new EasyPredictModelWrapper(MojoModel.load(modelPath))

  val prediction = model.predictRegression(testFeatures.toH2ORowData)

  println(s"Prediction: ${prediction.value}")
}
