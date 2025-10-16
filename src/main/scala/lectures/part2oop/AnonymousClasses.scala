package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahah")
  }

  /*
    class AnonymousClasses$$anon$1 extends Animal{
        override def eat: Unit = println("hahahah")
    }
   */

  println(funnyAnimal.getClass)
}
