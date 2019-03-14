package mbcs

case class UserAccountId(value: Long) {

  def asHash: Hash = Hash(value.toString)

}

