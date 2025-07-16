package br.com.applabpe.lastbtcblock.screens.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.applabpe.lastbtcblock.model.AddressInfo
import br.com.applabpe.lastbtcblock.model.BlockInfo
import br.com.applabpe.lastbtcblock.model.TransactionInfo
import br.com.applabpe.lastbtcblock.repository.BTCRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val repository: BTCRepository): ViewModel() {

    private val _blockInfo = MutableLiveData<BlockInfo>()
    val blockInfo: LiveData<BlockInfo>
        get() = _blockInfo

    private val _addressInfo = MutableLiveData<AddressInfo>()
    val addressInfo: LiveData<AddressInfo>
        get() = _addressInfo

    private val _lastHash = MutableLiveData<String>()
    val lastHash: LiveData<String>
        get() = _lastHash

    private val _txInfo = MutableLiveData<TransactionInfo>()
    val txInfo: LiveData<TransactionInfo>
        get() = _txInfo

    val error = MutableLiveData<String>()

    @SuppressLint("SimpleDateFormat")
    fun getLastBlock() {
        viewModelScope.launch {
            try {
                val block = repository.getLatestBlock()
                _blockInfo.value = block
//                val time = block.time * 1000
//                val date = Date(time)
//                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
//                val blockTime = sdf.format(date)
                val totalValue = getBlockTotalValue(block.txIndexes)
                getTxInfo(block.txIndexes.get(0))
//                val size = _txInfo.value?.size
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }

    fun getTxInfo(tx: Long) {
        viewModelScope.launch {
            try {
                val info = repository.getTransactionInfo(tx)
                _txInfo.value = info
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }

    fun getAddrInfo(addr: String) {
        viewModelScope.launch {
            try {
                val response = repository.getAddressInfo(addr)
                _addressInfo.postValue(response)
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }

    fun getBlockTotalValue(txIndexes: List<Long>): Long {
        var total:Long = 0
        for (index in txIndexes) {
            viewModelScope.launch {
                val info = repository.getTransactionInfo(index)
                val outs = info.out;
                for (out in outs) {
                    total += out.value
                }
            }
        }
        return total
    }
}