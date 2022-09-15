package com.shadi.shadiproject.presentation.shadi_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shadi.shadiproject.presentation.shadi_list.compose.ShadiListItem

@Composable
fun ShadiListPage(
    viewModel: ShadiListViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (viewModel.shadiState.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                itemsIndexed(
                    viewModel.shadiState.shadiListEntity
                ) { index, item ->

                    ShadiListItem(shadiListEntity = item, {
                        viewModel.onEvent(
                            ShadiListEvent.AcceptRequest(item)
                        )
                    },
                        {
                            viewModel.onEvent(
                                ShadiListEvent.RejectRequest(item)
                            )
                        }
                    )

                }
            }
        }
    }
}


@Preview(name = "ShadiListPage", showBackground = true)
@Composable
fun ShadiListPagePreview() {
    ShadiListPage()
}