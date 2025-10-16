package lectures.part1basics

object DefaultArgs extends App {

    
  def trFact(n: Int, acc: Int): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact1 = trFact(10, 1)
}
