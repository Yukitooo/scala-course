package lectures.part2oop

object CaseClasses extends App {
  /*
        equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

// 1. class parameters are fields
  val jim = new Person("Jim", 34)

  // 2. sensible toString
  // println(instance) = print(instance.toString) // syntactic sugar
  println(jim.toString())

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case classes have companion objects

  val thePerson = Person
  val mary = Person.apply("Mary", 23)

  //6. Case classes are serealizable
  // Akka 

  // 7. Case classes have extractor patterns = CCs can be used in PATTERN MATCHING.

  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }

}
