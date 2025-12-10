package br.com.applabpe.lastbtcblock.network

import br.com.applabpe.lastbtcblock.model.AddressInfo
import br.com.applabpe.lastbtcblock.model.BlockInfo
import br.com.applabpe.lastbtcblock.model.TransactionInfo
import br.com.applabpe.lastbtcblock.model.TxInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface BlockCypherApiService {
    @GET("txs/{tx_info}")
    suspend fun getTxInfo(@Path("tx_info") txInfo: Long): TxInfo

}