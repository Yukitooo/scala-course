package lectures.part2oop

object OOBasics extends App {
  val author = new Novel("Percival's Book", "2020", "Giovanni")

  println(author.authorAge(5))
  println(author.isWrittenBy())
  println(author.copy("2001"))

}

class Novel(val name: String, val yearOfRelease: String, val author: String) {
  def authorAge(age: Int): Unit = {
    println(s"$name is $age years old.")
  }

  def isWrittenBy(): Unit = {
    println(s"This book is written by $author")
  }

  def copy(newYearOfRelease: String): Unit = {
    val newAuthor = new Novel(name, newYearOfRelease, author)
    println(newAuthor.yearOfRelease)
  }
}
