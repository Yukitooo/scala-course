package lectures.part2oop

object InheritanceAndTraits extends App {

  // singe class inheritance
  class Animal { // Animal is a superclass of cat
    val creatureType = "wild"
    def eat = println("nomnom!")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  } // Cat is a subclass of Animal

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {

    override def eat = {
      super.eat
      println("crunch, crunch!")
    }
  }

  val dog = new Dog("k9")
  dog.eat
  println(dog.creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("k9")
  unknownAnimal.eat

  // super

  // preventing overrides
  // 1. use final on member
  // 2. use final on the entire class
  // 3. seal the class- extend classes in THIS FILE, prevent extension in other files

}
