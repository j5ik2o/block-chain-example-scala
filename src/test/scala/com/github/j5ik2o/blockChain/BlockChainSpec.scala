package com.github.j5ik2o.blockChain

import java.time.Instant

import org.scalatest.{FreeSpec, Matchers}

class BlockChainSpec extends FreeSpec with Matchers {

  "BlockChain" - {
    "apply" in {
      val blockChain = BlockChain()
      val (newBlockChain1, _) = blockChain.newBlock(Transactions(Transaction("ABC", UserAccountId(1), Instant.now())))
      val (newBlockChain2, _) = newBlockChain1.newBlock(Transactions(Transaction("DEF", UserAccountId(1), Instant.now())))
      val (newBlockChain3, _) = newBlockChain2.newBlock(Transactions(Transaction("GHI", UserAccountId(1), Instant.now())))
      newBlockChain3.validate shouldBe true
    }
  }

}
