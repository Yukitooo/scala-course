package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "Hello, scala!") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // accessing index thus 2
  println(aTuple.copy(_2 = "goodbye java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789)
  // a -> b is sugar for (a, b)
  println(phonebook)

  // add a pairing

  val newPairing = "Mary" -> 678
  val newPhoneBook = phonebook + newPairing

  // functionals on maps
  // map, flatMap, filter

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))

  // mapValues
  println(phonebook.mapValues(number => "083-" + number))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Jim", 555), ("Daniel", 789)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
