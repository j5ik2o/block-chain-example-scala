package com.github.j5ik2o.blockChain

import java.time.Instant

case class Transaction(message: String,
                       senderId: UserAccountId,
                       createdAt: Instant,
                       receiverIds: UserAccountIds = UserAccountIds.empty) {
  def asHash: Hash =
    Hash(Hash(message), senderId.asHash, Hash(createdAt.toEpochMilli.toString), receiverIds.asHash)

}
