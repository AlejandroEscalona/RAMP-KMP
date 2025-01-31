package kmp.project.rickandmortyapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.cash.paging.compose.LazyPagingItems

import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kmp.project.rickandmortyapp.ui.core.extensions.vertical
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersScreen() {
    val characterViewModel = koinViewModel<CharacterViewModel>()
    val state by characterViewModel.state.collectAsState()
    val characters = state.characters?.collectAsLazyPagingItems()

    Column {
        CharacterOfTheDay(state.characterOfTheDay)
        CharactersList(characters)
    }
}

@Composable
fun CharactersList(characters: LazyPagingItems<CharacterModel>?) {

}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(12),
        elevation = 8.dp
    ) {
        if (characterModel != null) {
            Box(
                contentAlignment = Alignment.BottomStart,
            ) {
                AsyncImage(
                    model = characterModel.image,
                    contentDescription = characterModel.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )

                Box(
                    Modifier.fillMaxSize().background(
                        Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startX = 1000f,
                            endX = 0f
                        )
                    )
                )
                Text(
                    characterModel.name,
                    fontSize = 20.sp,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .fillMaxHeight()
                        .vertical()
                        .rotate(-90f)

                )
            }
        } else {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}