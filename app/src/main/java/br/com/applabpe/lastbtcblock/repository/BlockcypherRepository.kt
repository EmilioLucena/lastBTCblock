package br.com.applabpe.lastbtcblock.repository

import br.com.applabpe.lastbtcblock.model.AddressInfo
import br.com.applabpe.lastbtcblock.model.BlockInfo
import br.com.applabpe.lastbtcblock.model.TransactionInfo
import br.com.applabpe.lastbtcblock.model.TxInfo
import br.com.applabpe.lastbtcblock.network.BlockCypherApiService
import br.com.applabpe.lastbtcblock.network.BlockchainInfoApiService
import javax.inject.Inject

class BlockcypherRepository @Inject constructor(private val api: BlockCypherApiService) {
    suspend fun  getTxInfo(tx: Long): TxInfo = api.getTxInfo(tx)
}