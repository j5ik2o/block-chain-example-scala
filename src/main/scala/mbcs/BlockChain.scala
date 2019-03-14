package mbcs

object BlockChain {

  def apply(): BlockChain = new BlockChain(Seq(Block.genesisBlock))

  def validate(chain: Seq[Block]): Boolean = {
    chain.zip(chain.tail).forall {
      case (p, s) =>
        s.validateBlock(p)
    }
  }

}

case class BlockChain private (blocks: Seq[Block]) {

  val headBlock: Block     = blocks.head
  val lastBlock: Block     = blocks.last
  val lastBlockId: BlockId = lastBlock.id
  val size: Int            = blocks.size

  def newBlock(transactions: Transactions): (BlockChain, Block) = {
    val block = Block(lastBlock, lastBlock.proof.nextProof, transactions)
    (BlockChain(blocks :+ block), block)
  }

  def validate: Boolean = BlockChain.validate(blocks)

  def resolveConflicts(nodes: Seq[String], getFullChain: String => Seq[Block]): Option[BlockChain] = {
    nodes.toStream
      .map(getFullChain).find { fullChain =>
        fullChain.size > size && BlockChain.validate(fullChain)
      }.map(BlockChain(_))
  }

}
