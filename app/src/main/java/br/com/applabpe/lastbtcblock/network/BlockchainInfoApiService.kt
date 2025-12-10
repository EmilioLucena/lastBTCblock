package br.com.applabpe.lastbtcblock.network

import br.com.applabpe.lastbtcblock.model.AddressInfo
import br.com.applabpe.lastbtcblock.model.BlockInfo
import br.com.applabpe.lastbtcblock.model.TransactionInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface BlockchainInfoApiService {
    @GET("latestblock")
    suspend fun getLatestBlock(): BlockInfo

    @GET("rawblock/{block_Hash}")
    suspend fun getBlock(@Path("block_hash") blockHash: String): BlockInfo

    @GET("rawtx/{tx_info}")
    suspend fun getTransactionInfo(@Path("tx_info") txInfo: Long): TransactionInfo

    @GET("rawaddr/{address}")
    suspend fun getAddressInfo(@Path("address") address: String): AddressInfo
}