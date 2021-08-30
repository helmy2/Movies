package com.example.movies.ui.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchAppBar(
    value: String,
    onValueChange: (String) -> Unit,
    onBackClicked: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    TopAppBar(
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = "Search")
            },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        onBackClicked()
                    }
                )
            },
            singleLine = true,
            shape = RectangleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                leadingIconColor = MaterialTheme.colors.onBackground,
                backgroundColor = MaterialTheme.colors.background,
                cursorColor = MaterialTheme.colors.onBackground,
                focusedIndicatorColor = MaterialTheme.colors.onBackground
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    focusManager.clearFocus()
                }
            ),
        )
    }
}

@Preview
@Composable
fun SearchAppBarPreview() {
    SearchAppBar(value = "", onValueChange = {},{})
}