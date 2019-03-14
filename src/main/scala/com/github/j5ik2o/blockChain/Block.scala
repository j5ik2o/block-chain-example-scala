package com.github.j5ik2o.blockChain

import java.time.Instant


case class Block private (id: BlockId,
                          previousHash: Option[Hash],
                          timestamp: Instant,
                          transactions: Transactions,
                          proof: Proof,
                          hash: Hash) {

  def validateHash: Boolean =
    Block.generateHash(this) == hash

  def validateBlock(prevBlock: Block): Boolean =
    validateHash && Block.validateBlock(this, prevBlock)

}

object Block {

  val genesisBlock: Block = newBlock(Proof.genesisProof, Transactions.empty, None)

  def apply(lastBlock: Block, proof: Proof, transactions: Transactions): Block =
    newBlock(proof, transactions, Some(lastBlock))

  private def newBlock(proof: Proof, transactions: Transactions, lastBlockOpt: Option[Block]): Block = {
    lastBlockOpt
      .map { lastBlock =>
        val id        = lastBlock.id.next
        val timestamp = Instant.now()
        new Block(id,
                  Some(lastBlock.hash),
                  timestamp,
                  transactions,
                  proof,
                  generateHash(id, Some(lastBlock.hash), timestamp, proof, transactions))
      } getOrElse {
      val timestamp = Instant.now()
      new Block(BlockId.genesisBlockId,
                None,
                Instant.now(),
                transactions,
                proof,
                generateHash(BlockId.genesisBlockId, None, timestamp, proof, transactions))
    }
  }

  private def generateHash(block: Block): Hash = {
    generateHash(block.id, block.previousHash, block.timestamp, block.proof, block.transactions)
  }

  private def generateHash(index: BlockId,
                           prevHashOpt: Option[Hash],
                           timestamp: Instant,
                           proof: Proof,
                           transactions: Transactions): Hash = {
    Hash(index.asHash,
         prevHashOpt.getOrElse(Hash("")),
         Hash(timestamp.toEpochMilli.toString),
         proof.asHash,
         transactions.asHash)
  }

  def validateBlock(block: Block, prevBlock: Block): Boolean = {
    (prevBlock, block) match {
      case (p, n) if !n.id.isValid(p.id) =>
        false
      case (p, n) if !n.previousHash.contains(p.hash) =>
        false
      case (_, n) if generateHash(n) != n.hash =>
        false
      case (p, n) if !n.proof.validate(p.proof) =>
        false
      case _ => true
    }
  }

}
