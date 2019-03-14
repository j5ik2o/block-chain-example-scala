package mbcs

object UserAccountIds {

  val empty = UserAccountIds(Seq.empty)

}

case class UserAccountIds(values: Seq[UserAccountId]) {

  def asHash: Hash = Hash(values.map(_.asHash): _*)

}
