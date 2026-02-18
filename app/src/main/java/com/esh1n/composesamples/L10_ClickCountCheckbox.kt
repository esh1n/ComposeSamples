package com.esh1n.composesamples

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

private const val TAG = "ClickCountWithCheckBox"

@Composable
fun ClickCountWithCheckBox() {
    Column() {
        val counter = remember {
            mutableStateOf(5)
        }
        val isUpperCase = remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "isUpperCase"
            )
            Checkbox(
                checked = isUpperCase.value,
                onCheckedChange = { isUpperCase.value = it }
            )
        }
        ClickCounter(isUpperCase.value, counter.value) { counter.value++ }
    }
}

@Composable
fun ClickCounter(isUpperCase: Boolean, count: Int, onClick: () -> Unit) {
    Column() {
        val evenOdd = remember(isUpperCase) {
            EvenOdd(isUpperCase)
        }
        Text(text = "Count: ${count}! even? : ${evenOdd.check(count)}")
        Text(
            text = "Нажми тут",
            modifier = Modifier.clickable { onClick() })
        Log.d(TAG, "ClickCounter $count ${evenOdd}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val counter = remember {
        mutableIntStateOf(5)
    }
    ClickCounter(false, counter.intValue, {})
}

class EvenOdd(private val isUpperCase: Boolean) {
    fun check(value: Int): String {
        val result = if (value % 2 == 0) {
            "even"
        } else {
            "odd"
        }
        return if (isUpperCase) {
            result.uppercase()
        } else {
            result
        }
    }

    override fun toString(): String {
        return "EvenOdd(isUpperCase=$isUpperCase) hashcode ${hashCode()}"
    }
}