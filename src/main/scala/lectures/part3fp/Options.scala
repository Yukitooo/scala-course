package lectures.part3fp

object Options extends App {

  // --------------------------------------------
  // 1️⃣ WHAT IS AN OPTION?
  // --------------------------------------------
  // Option is a container for a value that might be there (Some)
  // or might not be there (None). It's Scala's way of avoiding null.

  val someValue: Option[Int] = Some(42) // ✅ Has a value
  val noValue: Option[Int] = None // ❌ No value

  println(s"someValue: $someValue") // Some(42)
  println(s"noValue: $noValue") // None

  // --------------------------------------------
  // 2️⃣ WHY WE USE OPTION INSTEAD OF NULL
  // --------------------------------------------
  // Using null is dangerous — it can cause NullPointerException.
  // Option makes us handle the "missing case" safely.

  def unsafeMethod(): String = null
  // val result = unsafeMethod().length  ❌ Crashes with NPE!

  def safeMethod(): Option[String] = None
  val safeResult = safeMethod() // ✅ Always safe to use

  // --------------------------------------------
  // 3️⃣ CREATING OPTIONS SAFELY
  // --------------------------------------------
  // Option(...) automatically wraps a value into Some or None
  // depending on whether it's null or not.

  val maybeNull: String = null
  val safeOption: Option[String] = Option(maybeNull)
  println(s"safeOption: $safeOption") // None

  val maybeNotNull: String = "Scala"
  val safeOption2: Option[String] = Option(maybeNotNull)
  println(s"safeOption2: $safeOption2") // Some(Scala)

  // --------------------------------------------
  // 4️⃣ WORKING WITH OPTION VALUES
  // --------------------------------------------
  // Since Option might be Some or None, we usually use pattern matching or built-in methods.

  val greeting: Option[String] = Some("Hello!")

  // Pattern Matching
  val message = greeting match {
    case Some(value) => s"Greeting: $value"
    case None        => "No greeting found."
  }
  println(message)

  // --------------------------------------------
  // 5️⃣ getOrElse - Provide a default if None
  // --------------------------------------------
  val unknown: Option[String] = None
  println(unknown.getOrElse("Default value")) // "Default value"

  // --------------------------------------------
  // 6️⃣ map - Transform the value inside Option
  // --------------------------------------------
  val number: Option[Int] = Some(10)
  val doubled: Option[Int] =
    number.map(_ * 2) // Applies *2 if Some, does nothing if None
  println(doubled) // Some(20)

  val noneNumber: Option[Int] = None
  val doubledNone = noneNumber.map(_ * 2)
  println(doubledNone) // None

  // --------------------------------------------
  // 7️⃣ flatMap - Chain computations that return Option
  // --------------------------------------------
  def half(x: Int): Option[Int] =
    if (x % 2 == 0) Some(x / 2) else None

  val result1 = Some(20).flatMap(half) // Some(10)
  val result2 = Some(21).flatMap(half) // None
  println(result1)
  println(result2)

  // --------------------------------------------
  // 8️⃣ filter - Keep the value only if condition is true
  // --------------------------------------------
  val maybeEven = Some(4).filter(_ % 2 == 0) // Some(4)
  val maybeOdd = Some(5).filter(_ % 2 == 0) // None
  println(maybeEven)
  println(maybeOdd)

  // --------------------------------------------
  // 9️⃣ Combining Options - for comprehension
  // --------------------------------------------
  // Often, you want to use multiple Option results together. For-comprehensions make this clean.

  val optA: Option[Int] = Some(10)
  val optB: Option[Int] = Some(5)

  val combined: Option[Int] = for {
    a <- optA
    b <- optB
  } yield a + b

  println(combined) // Some(15)

  // --------------------------------------------
  // 🔟 Real-world Example - Lookup user by ID
  // --------------------------------------------
  def findUser(id: Int): Option[String] =
    if (id == 1) Some("Alice") else None

  def getGreeting(user: String): Option[String] =
    Some(s"Hello, $user!")

  val userGreeting: Option[String] = for {
    user <- findUser(1)
    greet <- getGreeting(user)
  } yield greet

  println(userGreeting) // Some("Hello, Alice!")

  val missingGreeting: Option[String] = for {
    user <- findUser(42)
    greet <- getGreeting(user)
  } yield greet

  println(missingGreeting) // None

  // --------------------------------------------
  // 📊 Summary
  // --------------------------------------------
  /*
    ✅ Option is a safer alternative to null.
    ✅ Some(value) = value exists, None = no value.
    ✅ Use:
        - getOrElse(default): to provide a fallback
        - map: to transform the value if it exists
        - flatMap: to chain computations that return Options
        - filter: to keep the value only if it satisfies a condition
        - for-comprehension: to work with multiple Options elegantly
    ✅ Never call .get directly — it throws an exception if None.
   */

}
