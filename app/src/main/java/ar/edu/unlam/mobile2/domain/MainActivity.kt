package ar.edu.unlam.mobile2.domain


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults

import androidx.compose.material3.Card

import androidx.compose.material.TabRow

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R

import ar.edu.unlam.mobile2.data.Tabs_item
import ar.edu.unlam.mobile2.repository.ArticuloApiModel
import ar.edu.unlam.mobile2.repository.MediaStackRestRepo


import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val mediaStackRepository = MediaStackRestRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EjemploNewsList(mediaStackRepository = mediaStackRepository)


        //Tabs_Principal()
            //AppContainer(ArticuloRepository.articulos)
        }
    }
}


@Composable
fun EjemploNewsList(mediaStackRepository: MediaStackRestRepo) {
    val newsList = remember { mutableStateOf(emptyList<ArticuloApiModel>()) }

    LaunchedEffect(Unit) {
        val news = mediaStackRepository.getNews()
        newsList.value = news
    }

    LazyColumn {
        items(newsList.value) { news ->
            EjemploNewsItem(news)
        }
    }
}

@Composable
fun EjemploNewsItem(news: ArticuloApiModel) {
    Card(
        shape = RoundedCornerShape(8.dp),

        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = news.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = news.description,
                fontSize = 16.sp,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Published at ${news.publishedAt}",
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray
            )
        }
    }
}



/*@Preview(showSystemUi = true)
@Composable
fun MyApp() {
    AppContainer(ArticuloRepository.articuloApiModels)
}

 */

@Composable
fun AppContainer(articuloApiModels: List<ArticuloApiModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        items(articuloApiModels) { articulo ->
            Cards(articulo)
        }
    }
}


@Composable
fun Cards(articuloApiModel: ArticuloApiModel) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
    ) {
        ItemsNews(articuloApiModel)
    }
}

@Composable
fun MyText(text: String) {
    Text(text = text)
}

@Composable
fun ItemsNews(articuloApiModel: ArticuloApiModel) {
    Column(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "NewsBackground",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        MyText(text = articuloApiModel.publishedAt)
        MyText(text = articuloApiModel.title)
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs_Principal() {
    val tabs = listOf(
        Tabs_item.item_general,
        Tabs_item.item_politica,
        Tabs_item.item_muscia
    )
    val pagerState = rememberPagerState()
    Column() {
        Tabs(tabs, pagerState)
        Tabs_content(tabs, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<Tabs_item>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tabsItem ->
            androidx.compose.material3.LeadingIconTab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                icon = {
                    androidx.compose.material.Icon(
                        painter = painterResource(id = tabsItem.icon),
                        contentDescription = ""
                    )
                },
                text = { Text(tabsItem.title) })

        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs_content(tabs: List<Tabs_item>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}
/*override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
}*/
