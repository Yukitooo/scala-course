package lectures.part3fp

object WhatsaFunction extends App {

  // DREAM: use functions as first class elements

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler.apply(2))

  // ALL SCALA FUNCTIONS ARE OBJECTS

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
