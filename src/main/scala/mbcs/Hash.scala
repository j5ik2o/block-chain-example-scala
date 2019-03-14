package mbcs

object Hash {

  def apply(values: Hash*): Hash =
    new Hash(values.map(_.asString).mkString(":"))

  def apply(value: String): Hash =
    new Hash(value)

}

case class Hash(value: String) {

  def asString: String = {
    MD5Function.sha256String(value)
  }

}
