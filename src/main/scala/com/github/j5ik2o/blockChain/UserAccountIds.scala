package com.github.j5ik2o.blockChain

object UserAccountIds {

  val empty = UserAccountIds(Seq.empty)

}

case class UserAccountIds(values: Seq[UserAccountId]) {

  def asHash: Hash = Hash(values.map(_.asHash): _*)

}
