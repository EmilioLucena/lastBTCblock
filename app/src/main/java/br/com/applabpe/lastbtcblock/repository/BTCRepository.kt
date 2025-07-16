package br.com.applabpe.lastbtcblock.repository

import br.com.applabpe.lastbtcblock.model.AddressInfo
import br.com.applabpe.lastbtcblock.model.BlockInfo
import br.com.applabpe.lastbtcblock.model.TransactionInfo
import br.com.applabpe.lastbtcblock.network.BitcoinApiService
import javax.inject.Inject

class BTCRepository @Inject constructor(private val api: BitcoinApiService) {
    suspend fun  getLatestBlock(): BlockInfo = api.getLatestBlock()

    suspend fun getBlockInfo(hash: String): BlockInfo {
        val blockInfo = api.getBlock(hash)
        return blockInfo
    }

    suspend fun getAddressInfo(address: String): AddressInfo {
        val info = api.getAddressInfo(address)
        return info
    }

    suspend fun  getTransactionInfo(tx: Long): TransactionInfo = api.getTransactionInfo(tx)
}