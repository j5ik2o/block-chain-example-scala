package com.github.j5ik2o.blockChain

object Blocks {

  def apply(block: Block): Blocks =
    new Blocks(Seq(block))

}

case class Blocks(values: Seq[Block]) {
  def head: Block = values.head
  def last: Block = values.last
  def size: Int = values.size
  def add(others: Blocks): Blocks =
    copy(values = values ++ others.values)
  def add(other: Block): Blocks =
    add(Blocks(Seq(other)))
}

