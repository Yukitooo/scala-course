package lectures.part4pm

import lectures.part2oop.CaseClasses.mary

object AllthePatters {
  // 1-constants
  val x: Any = "Scala"
  val constants = x match {
    case 1             => " a number"
    case "Scala"       => "The sacala"
    case true          => "The truth"
    case AllthePatters => "A singleton object"
  }

  // 2 - match everything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ => "matched with any!"
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"Ive found $something"
  }

  // 3- tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1)         =>
    case (something, 2) => s"Ive found $something"

  }
  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // 4 -case classes - constructor pattern
  // PMS can be nested with CCs as well

  // 5= list patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _)    => // extractor - advanced
    case List(1, _*)         => // list of arbitrary length - advanced
    case 1 :: List(_)        =>
    case List(1, 2, 3) :+ 42 => // infix pattern
  }

  // 6-type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _               =>
  }

}
