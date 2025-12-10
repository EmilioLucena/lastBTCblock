package br.com.applabpe.lastbtcblock.model

import com.google.gson.annotations.SerializedName

data class TxInfo(
    @SerializedName("hash") val hash: String,
    @SerializedName("size") val size: Int,
    @SerializedName("block_height") val blockHeight: Int,
    @SerializedName("block_index") val blockIndex: Int,
    @SerializedName("total") val total: Long,
    @SerializedName("fees") val fees: Long,
    @SerializedName("confirmed") val confirmedAt: String,
    @SerializedName("inputs") val inputs: List<InputValues>,
    @SerializedName("outputs") val out: List<OutputValue>
)

data class InputValues(
    @SerializedName("output_value") val outputValue: Long,
    @SerializedName("addresses") val addresses: List<String>,
)
data class OutputValue(
    @SerializedName("value") val value: Long,
    @SerializedName("addresses") val addresses: List<String>
)
