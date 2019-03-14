package com.github.j5ik2o.blockChain

object BlockChain {

  def apply(): BlockChain = new BlockChain(Blocks(Block.genesisBlock))

  def validate(chain: Blocks): Boolean = {
    chain.values.zip(chain.values.tail).forall {
      case (p, s) =>
        s.validateBlock(p)
    }
  }

}

case class BlockChain private (blocks: Blocks) {

  val headBlock: Block     = blocks.head
  val lastBlock: Block     = blocks.last
  val lastBlockId: BlockId = lastBlock.id
  val size: Int            = blocks.size

  def newBlock(transactions: Transactions): (BlockChain, Block) = {
    val block = Block(lastBlock, lastBlock.proof.nextProof, transactions)
    (BlockChain(blocks add block), block)
  }

  def validate: Boolean = BlockChain.validate(blocks)

  def resolveConflicts(nodes: Seq[String], getFullChain: String => Blocks): Option[BlockChain] = {
    nodes.toStream
      .map(getFullChain).find { fullChain =>
        fullChain.size > size && BlockChain.validate(fullChain)
      }.map(BlockChain(_))
  }

}
