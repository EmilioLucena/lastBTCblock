package br.com.applabpe.lastbtcblock.model

import com.google.gson.annotations.SerializedName

data class BlockInfo(
    @SerializedName("hash") val hash: String,
    @SerializedName("time") val time: Long,
    @SerializedName("height") val blockHeight: Int,
    @SerializedName("txIndexes") val txIndexes: List<Long>,
    @SerializedName("prev_block") val previousBlock: String
)
