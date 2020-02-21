class mapFilter {
  def bedrooms: Array[Any] = {
    val lines = io.Source.fromFile ("src/main/rsc/RealEstate.csv")
        .getLines
        .drop (1)
        .map (x => x.split (",") )
        .toArray

    val bedrooms = lines.map (x => x (3) ).filter (x => x matches "[1-4]")
    val size = bedrooms.map {
        case "1" => "Chico"
        case "2" => "Mediano"
        case "3" => "Grande"
        case "4" => "Familiar"
        case _ =>
    }
    size
  }
}

object Main extends App {
  var bedrooms = new mapFilter
  println(bedrooms.bedrooms.toList)
}


