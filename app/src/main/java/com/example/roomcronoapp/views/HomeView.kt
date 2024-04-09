package com.example.roomcronoapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomcronoapp.components.CronoCard
import com.example.roomcronoapp.components.FloatButton
import com.example.roomcronoapp.components.MainTitle
import com.example.roomcronoapp.components.formatTime
import com.example.roomcronoapp.viewModel.CronosViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController,cronosVM: CronosViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    MainTitle(title = "CRONO APP")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )

            )
        },

        floatingActionButton = {
            FloatButton {
                navController.navigate("AddView")
            }

        }


    ) {
        ContentHomeview(it = it, navController = navController,cronosVM)
    }
}

@Composable
fun ContentHomeview(it: PaddingValues, navController: NavController,cronosVM: CronosViewModel) {
    Column(modifier = Modifier.padding(it))
    {
        val cronosList by cronosVM.cronosList.collectAsState()
        LazyColumn{
            items(cronosList){items ->
                val delete = SwipeAction(
                    icon = rememberVectorPainter(Icons.Default.Delete),
                    background = Color.Red,
                    onSwipe = {cronosVM.deleteCrono(items)}
                )

                SwipeableActionsBox(endActions = listOf(delete), swipeThreshold = 100.dp) {
                    CronoCard(items.title, formatTime(items.crono) ) {
                         navController.navigate("EditView/${items.id}")
                    }
                }

            }
        }
    }
}