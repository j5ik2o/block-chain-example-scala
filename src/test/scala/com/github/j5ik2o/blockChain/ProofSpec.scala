package com.github.j5ik2o.blockChain

import org.scalatest.{FreeSpec, Matchers}

class ProofSpec extends FreeSpec with Matchers {
  "Proof" - {
    "validate" in {
      val next = Proof.genesisProof.nextProof
      next.validate(Proof.genesisProof) shouldBe true
    }
  }
}
