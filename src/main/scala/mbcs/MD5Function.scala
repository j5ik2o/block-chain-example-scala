package mbcs

import java.security.MessageDigest

object MD5Function {

  private val md = MessageDigest.getInstance("SHA-256")

  def sha256(input: String): Array[Byte] = {
    sha256(input.getBytes())
  }

  def sha256(input: Array[Byte]): Array[Byte] = {
    md.digest(input)
  }

  def sha256String(input: String): String = {
    sha256String(input.getBytes())
  }

  def sha256String(input: Array[Byte]): String = {
    sha256(input).map{ b => "%02x".format(b)}.mkString
  }

}
