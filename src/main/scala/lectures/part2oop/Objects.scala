package lectures.part2oop

object Objects extends App {

  object Person {
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance=level functionality
  }

  // class Person and object Person are COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGELETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // true

  val bobbie = Person(mary, john)
  println(bobbie.name)

  // Scala Applications = Scala obejct with
  // def main(args: Array[String]): Unit

}
