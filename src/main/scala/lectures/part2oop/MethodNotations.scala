package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person =
      new Person(s"$name ($nickname)", favoriteMovie, age)

    def unary_! : String = s"$name, what the heck!?"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String =
      s"Hi, my name is $name and I like $favoriteMovie. I am $age years old."
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception", 20)
  println(mary.likes("Inception"))
  println(
    mary likes "Inception"
  ) // infix notation = operator notation (syntactic sugar)

  // "operators" in scala

  val tom = new Person("Tom", "Fight Club", 25)
  println(mary + tom)

  // prefix notiation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only wotks with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1. Overload the + operator
    mary + "the rockstar" => new Person "Mary (the rockstar)"



    2. Add an age to the Person class
       Add a unary + operator => new person with the age + 1
       +mary => mary with the age incrementer

    3. Add a "learns" method in the Person class => "Mary learns scala"
    Adda learnScala method, calls learns method with "Scala"
    Use it in postfix notation.

    4. Overload the apply method
    mary.apply(2) => "Mary watched Inception 2 times."
   */

  println(mary.+("the rockstar").apply())

  println((+mary).age)
  println(mary.learnsScala)

}
