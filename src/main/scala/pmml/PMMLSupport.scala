package pmml

import java.util

import model.BostonHousingFeatureSet
import org.dmg.pmml.FieldName

/**
  * Mixin trait that provides conversions to the correct feature representation needed by PMML.
  */
trait PMMLSupport {

  this: BostonHousingFeatureSet =>

  def toPMMLArgumentMap: util.HashMap[FieldName, _] = {

    val map = new util.HashMap[FieldName, Any]()

    map.put(new FieldName("CRIM"), crimeRate)
    map.put(new FieldName("ZN"), residentialLand)
    map.put(new FieldName("INDUS"), nonRetailAcres)
    map.put(new FieldName("CHAS"), charlesRiverDummyVar)
    map.put(new FieldName("NOX"), nitricOxidesConcentration)
    map.put(new FieldName("RM"), numberOfRooms)
    map.put(new FieldName("AGE"), age)
    map.put(new FieldName("DIS"), distanceToDowntown)
    map.put(new FieldName("RAD"), highwayAccessibilityIndex)
    map.put(new FieldName("TAX"), propertyTaxRate)
    map.put(new FieldName("PTRATIO"), pupilTeacherRatio)
    map.put(new FieldName("B"), proportionOfBlackPopulation)
    map.put(new FieldName("LSTAT"), proportionOfLowerStatusPopulation)

    map
  }

}
