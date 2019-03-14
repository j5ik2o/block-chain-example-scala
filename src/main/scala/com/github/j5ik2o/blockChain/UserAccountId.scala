package com.github.j5ik2o.blockChain

case class UserAccountId(value: Long) {

  def asHash: Hash = Hash(value.toString)

}
