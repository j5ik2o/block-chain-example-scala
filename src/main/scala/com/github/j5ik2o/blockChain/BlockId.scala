package com.github.j5ik2o.blockChain

object BlockId {

  val genesisBlockId = BlockId(0L)

}

case class BlockId(value: Long) {

  def isValid(prevBlockId: BlockId): Boolean = value == prevBlockId.value + 1

  def asHash: Hash = Hash(value.toString)

  def next: BlockId = BlockId(value + 1)

}

