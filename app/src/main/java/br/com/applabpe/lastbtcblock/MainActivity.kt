package br.com.applabpe.lastbtcblock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.applabpe.lastbtcblock.screens.main.MainScreenViewModel
import br.com.applabpe.lastbtcblock.ui.theme.LastbtcblockTheme
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getLastBlock()
        setContent {
            LastbtcblockTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val blockInfo = viewModel.blockInfo.observeAsState()
    val totalTransactionValue = viewModel.totalTransactionValue.observeAsState()
    val transactionIndex = viewModel.transactionIndex.observeAsState()
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")

    blockInfo.value?.let {
        val height = it.blockHeight
        val transactionsCount = it.txIndexes.size
        val blockTime = sdf.format(Date(it.time * 1000))
        val totalValue = totalTransactionValue.value
        val txIdx = transactionIndex.value
        Column(
            Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                ,

                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                text = "Last BTC Block Info",
                fontSize = 32.sp
            )
            Text(text = "Altura = ${height}", fontSize = 20.sp)
            Text(text = "Data = $blockTime GMT-3", fontSize = 20.sp)
            Text(text = "#Transações = $txIdx / $transactionsCount", fontSize = 20.sp)
            Text(text = "Total = $totalValue" + " BTC", fontSize = 20.sp)
            Button(modifier = Modifier.padding(top = 20.dp),
                onClick = {
                    viewModel.getLastBlock()
                }) {
                Text(text = "Recarregar")
            }
//            Button(modifier = Modifier.padding(top = 20.dp),
//                onClick = {
//                    viewModel.getBlockTotalValue(it.txIndexes)
//                }) {
//                Text(text = "Obter valor")
//            }
        }
    }
//    totalTransactionValue.value?.let {
//
//    }
}
