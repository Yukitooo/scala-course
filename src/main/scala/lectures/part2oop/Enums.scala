package lectures.part2oop

object Enums {
  enum Permission {
    case READ, WRITE, EXECUTE, NONE

    // we can add fields/methods

    def openDocument(): Unit =
      if (this == READ) println("opening document...")
      else println("reading not allowed.")

  }

  val somePermissions: Permission = Permission.READ

  // constructor args
  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4) // 100
    case WRITE extends PermissionWithBits(2) // 010
    case EXECUTE extends PermissionWithBits(1) // 001
    case NONE extends PermissionWithBits(0)
  }

  //standard API 

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
  }
}
