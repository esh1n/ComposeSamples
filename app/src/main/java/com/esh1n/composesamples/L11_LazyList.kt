package com.esh1n.composesamples

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val TAG = "ListFrom11Lesson"

@Composable
fun SomeItem(text: String) {
    Log.d(TAG, "SomeItem $text")
    Text(text = text, fontSize = 20.sp, modifier = Modifier.padding(all = 16.dp))
}

@Composable
fun SomeItemContentPadding(text: String) {
    Log.d(TAG, "SomeItem $text")
    Text(
        text = text, fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)
    )
}

@Composable
fun HomeScreen11_LazyListContentPadding(){
    Log.d(TAG, "HomeScreen11_LazyListContentPadding")
    val list = remember {
        List(20){"Item ${it+1}"}.toMutableStateList()
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .border(width = 2.dp, color = Color.Green)
            //.padding(16.dp)
    ) {
        items(list) { item ->
            SomeItemContentPadding(text = item)
        }
    }
}

@Composable
fun HomeScreen11() {
    Log.d(TAG, "HomeScreen11")
    val list = remember {
       List(20){"Item ${it+1}"}.toMutableStateList()
    }
    val scrollState = rememberScrollState()
//    Column(modifier = Modifier.verticalScroll(scrollState)) {
//        TextButton(onClick = {
//            Log.d(TAG, "-insert new item-")
//            list.add(0, "Item ${list.size + 1}")
//        }) {
//            Text(text = "insert")
//        }
//        list.forEach { value ->
//            key(value) {
//                SomeItem(text = value)
//            }
//
//        }
//    }
    LazyColumn {
        items(list) { item ->
            SomeItem(text = item)
        }
    }
}