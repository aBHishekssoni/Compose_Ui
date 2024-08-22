package com.example.composeui.ui.screen

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeui.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun heroAnimation(modifier: Modifier = Modifier) {
    SharedTransitionLayout {
        val nc = rememberNavController()
        NavHost(navController = nc, startDestination = "list") {
            composable("list") { ListScreen(nc,this@SharedTransitionLayout,
                this@composable,modifier) }
            composable("detail/{item}", arguments = listOf(navArgument("item") { type = NavType.IntType })) {
                val id = it.arguments?.getInt("item") ?: 0
                val news = getList()[id]
                DetailScreen(
                    modifier = modifier,
                    nc,news,this@SharedTransitionLayout,this@composable
                )
            }
        }
    }
}
data class News(
    val title: String,
    val image: Int
)
fun getList() = listOf(
    News("Title 1", R.drawable.superhero_toy_png_file),
    News("Title 2", R.drawable.superhero_toy_png_file),
    News("Title 3", R.drawable.superhero_toy_png_file),
    News("Title 4", R.drawable.superhero_toy_png_file),
    News("Title 5", R.drawable.superhero_toy_png_file),
    News("Title 6", R.drawable.superhero_toy_png_file),
)
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListScreen(
    navController: NavHostController,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    modifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(getList()) { idx, item ->
         with(sharedTransitionScope){
             Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 modifier = Modifier
                     .padding(16.dp)
                     .clickable {
                         navController.navigate("detail/$idx")
                     }
             ) {
                 Image(
                     painter = painterResource(id = item.image),
                     contentDescription = null,
                     modifier = Modifier
                         .size(150.dp)
                         .clip(CircleShape)
                         .sharedElement(
                             sharedTransitionScope.rememberSharedContentState(key = item.title),
                             animatedVisibilityScope = animatedContentScope
                         )
                 )
                 Text(text = item.title, style = MaterialTheme.typography.labelLarge)
             }
         }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    nc: NavHostController,
    news: News,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = news.image), contentDescription = news.title,
            modifier = Modifier
                .fillMaxWidth()
                .sharedElement(
                    sharedTransitionScope.rememberSharedContentState(key = news.title),
                    animatedVisibilityScope = animatedContentScope
                ))
        Text(text = news.title, style = MaterialTheme.typography.displayLarge)
    }
}
}