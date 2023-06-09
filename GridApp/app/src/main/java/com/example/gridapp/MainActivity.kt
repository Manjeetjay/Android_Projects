package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridapp.data.Datasource
import com.example.gridapp.model.Grid
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowUIComponent()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ShowUIComponent() {
    GridList(gridList = Datasource().loadGrid())
}

@Composable
fun GridList(gridList: List<Grid>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gridList) { grid ->
            GridAppCard(
                grid = grid,
                modifier = modifier
            )
        }
    }
}




@Composable
fun GridAppCard(grid: Grid, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .height(68.dp)
        .clip(RoundedCornerShape(5.dp))) {
        Row {
            Image(
                painter = painterResource(id = grid.imageResourceID),
                contentDescription = stringResource(id = grid.stringResourceID),
                modifier = modifier
                    .padding(end = 16.dp)
                    .fillMaxHeight()
                    .size(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = grid.stringResourceID),
                    modifier = modifier.padding(top = 16.dp, bottom = 8.dp, end = 16.dp)
                )
                CardDescriptionInfo()
            }
        }
    }
}


@Composable
fun CardDescriptionInfo(modifier: Modifier = Modifier) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_grain),
            contentDescription = "grain",
            modifier = modifier
                .size(25.dp)
                .padding(end = 8.dp),
        )

        }
    }



