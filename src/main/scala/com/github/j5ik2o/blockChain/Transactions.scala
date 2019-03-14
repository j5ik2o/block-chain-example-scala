package com.github.j5ik2o.blockChain

object Transactions {

  val empty = Transactions(Seq.empty)

  def apply(value: Transaction): Transactions = Transactions(Seq(value))

}

case class Transactions(values: Seq[Transaction]) {

  def asHash: Hash = Hash(values.map(_.asHash): _*)

  def add(otherTransactions: Transactions): Transactions =
    copy(values = values ++ otherTransactions.values)

  def add(others: Seq[Transaction]): Transactions =
    copy(values = values ++ others)

  def add(other: Transaction): Transactions =
    copy(values = values ++ Seq(other))

}
