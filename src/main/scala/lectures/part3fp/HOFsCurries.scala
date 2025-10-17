package lectures.part3fp

object HOFsCurries extends App {
  // function that applioes a function n times over a value x
  // nTimes(f,n,x)
  // nTimes(f, 3, x) = f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3+y
  println(add3(10))
  println(superAdder(3)(10))

  // fujcntions with multiple parameter lists

  def curriedFormatter(c: String)(x: Double): String = c.format(x)
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
}
