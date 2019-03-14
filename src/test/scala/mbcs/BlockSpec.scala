package mbcs
import java.time.Instant

import org.scalatest.{ FreeSpec, Matchers }

class BlockSpec extends FreeSpec with Matchers {

  "Block" - {
    "apply" in {
      val aBlock = Block(Block.genesisBlock, Block.genesisBlock.proof.nextProof, Transactions(Transaction("ABC", UserAccountId(1), Instant.now())))
      aBlock.validateBlock(Block.genesisBlock) shouldBe true
    }
  }

}
