package com.shadi.shadiproject.presentation.shadi_list.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shadi.shadiproject.data.local.entity.ShadiListEntity
import com.shadi.shadiproject.retantions.ShadiStatus

@Composable
fun ShadiListItem(
    shadiListEntity: ShadiListEntity? = null,
    onAccept: (() -> Unit)? = null,
    onDeclined: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .height(500.dp)
        ) {
            val painter =
                rememberImagePainter(data = shadiListEntity?.pictureUrl)

            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painter,
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F)
                ) {

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = shadiListEntity?.firstName ?: (" " + shadiListEntity?.lastName)
                            ?: "",
                            style = MaterialTheme.typography.h6,
                            color = Color.White
                        )
                        Text(
                            text = shadiListEntity?.age?.let { it + "yrs" } ?: "",
                            style = MaterialTheme.typography.body1,
                            color = Color.White
                        )
                        Text(
                            text = shadiListEntity?.city ?: ("," + shadiListEntity?.state)
                            ?: "",
                            style = MaterialTheme.typography.body2,
                            color = Color.White
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {

                            if (shadiListEntity?.status != ShadiStatus.DEFAULT.type) {
                                Box(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .border(
                                            border = BorderStroke(1.dp, color = Color.White),
                                            shape = RoundedCornerShape(16.dp)
                                        )
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(8.dp),
                                        text = if(shadiListEntity?.status == ShadiStatus.ACCEPT.type)
                                            "User has Accepted Your Request"
                                        else
                                            "User has Declined Your Request",
                                        color = Color.White,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .weight(1F)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        modifier = Modifier
                                            .clip(CircleShape),
                                        shape = RoundedCornerShape(100.dp),
                                        onClick = {
                                            if (onAccept != null) {
                                                onAccept()
                                            }
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = MaterialTheme.colors.primary,
                                            backgroundColor = Color.White
                                        )
                                    ) {
                                        Text(
                                            text = "Accept",
                                            style = MaterialTheme.typography.button,
                                        )
                                    }
                                }

                                Button(
                                    modifier = Modifier.clip(CircleShape),
                                    shape = RoundedCornerShape(100.dp),
                                    onClick = {
                                        if (onDeclined != null) {
                                            onDeclined()
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = MaterialTheme.colors.primary,
                                        backgroundColor = Color.White
                                    )
                                ) {
                                    Text(
                                        text = "Declined",
                                        style = MaterialTheme.typography.button,
                                    )
                                }
                            }
                        }

                    }

                }


            }
        }

    }
}


@Preview(name = "ShadiListItem", showBackground = true)
@Composable
fun ShadiListItemPreview() {
    ShadiListItem()
}