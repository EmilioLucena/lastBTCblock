package br.com.applabpe.lastbtcblock.model

import com.google.gson.annotations.SerializedName

data class TransactionInfo(
    @SerializedName("hash") val hash: String,
    @SerializedName("size") val size: Int,
    @SerializedName("block_height") val blockHeight: Int,
    @SerializedName("out") val out: List<OutputValues>
)

data class OutputValues(
    @SerializedName("value") val value: Long,
    @SerializedName("hash") val hash: Long,
    @SerializedName("script") val script: String
)
