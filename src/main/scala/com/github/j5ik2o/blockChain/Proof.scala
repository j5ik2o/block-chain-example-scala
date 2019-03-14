package com.github.j5ik2o.blockChain

object Proof {

  val difficulty = 1

  private def proofOfWork(lastProof: Proof): Proof = {
    Iterator
      .continually(lastProof).zipWithIndex.filter {
        case (lp, proofValue) =>
          validateProof(lp, Proof(proofValue))
      }.map(v => Proof(v._2)).take(1).toStream.head
  }

  private def validateProof(lastProof: Proof, proof: Proof): Boolean = {
    val hash = Hash(lastProof.asHash, proof.asHash).asString
    val result = hash.startsWith("0" * difficulty)
    result
  }

  def genesisProof: Proof = proofOfWork(new Proof(0L))

}

case class Proof(value: Long) {

  import Proof._

  def asHash: Hash = Hash(value.toString)

  def nextProof: Proof = proofOfWork(this)

  def validate(prevProof: Proof): Boolean = validateProof(prevProof, this)

}