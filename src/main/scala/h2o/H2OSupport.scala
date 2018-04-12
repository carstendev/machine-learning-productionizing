package h2o

import hex.genmodel.easy.RowData
import model.BostonHousingFeatureSet

/**
  * Mixin trait that provides conversions to the correct feature representation needed by H2O.
  */
trait H2OSupport {

  this: BostonHousingFeatureSet =>

  def toH2ORowData: RowData = {

    val row = new RowData

    row.put("CRIM", crimeRate.toString)
    row.put("ZN", residentialLand.toString)
    row.put("INDUS", nonRetailAcres.toString)
    row.put("CHAS", charlesRiverDummyVar.toString)
    row.put("NOX", nitricOxidesConcentration.toString)
    row.put("RM", numberOfRooms.toString)
    row.put("AGE", age.toString)
    row.put("DIS", distanceToDowntown.toString)
    row.put("RAD", highwayAccessibilityIndex.toString)
    row.put("TAX", propertyTaxRate.toString)
    row.put("PTRATIO", pupilTeacherRatio.toString)
    row.put("B", proportionOfBlackPopulation.toString)
    row.put("LSTAT", proportionOfLowerStatusPopulation.toString)

    row
  }

}
