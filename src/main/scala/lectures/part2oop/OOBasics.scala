package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.greet("YUKI"))
  println(person.greet())
}

class Person(
    val name: String,
    val age: Int
) {
  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
}
