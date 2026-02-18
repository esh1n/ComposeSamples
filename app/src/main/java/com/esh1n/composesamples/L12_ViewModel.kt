package com.esh1n.composesamples

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun L12_HomeScreenState(vm: HomeViewModelState = viewModel()) {
    val counter by vm.counter
    Text(
        text = "Clicks: ${counter}",
        modifier = Modifier.clickable(onClick = { vm.onCounterClick() })
    )
}

class HomeViewModelState() : ViewModel() {
    private val _counter = mutableStateOf(0)

    val counter: State<Int> = _counter

    fun onCounterClick() {
        _counter.value++
    }
}

@Composable
fun L12_HomeScreenFlow(vm: HomeViewModelFlow = viewModel()) {
    val counter by vm.counter.collectAsState()
    Text(
        text = "Clicks: ${counter}",
        modifier = Modifier.clickable(onClick = { vm.onCounterClick() })
    )
}

class HomeViewModelFlow() : ViewModel() {
    private val _counter = MutableStateFlow(0)

    val counter: StateFlow<Int> = _counter

    fun onCounterClick() {
        _counter.value++
    }
}