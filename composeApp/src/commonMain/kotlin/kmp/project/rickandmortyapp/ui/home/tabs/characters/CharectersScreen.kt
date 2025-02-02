package kmp.project.rickandmortyapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
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
    val characters = state.characters.collectAsLazyPagingItems()

    Column {
        CharacterOfTheDay(state.characterOfTheDay)
        CharactersList(characters)
    }
}

@Composable
fun CharactersList(characters: LazyPagingItems<CharacterModel>) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        when {
            characters.itemCount == 0 -> {
                item(
                    span = { GridItemSpan(2) }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            else -> {
                items(characters.itemCount) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(24))
                            .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(0, 24, 0, 24))
                            .fillMaxSize()
                            .clickable { },
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        AsyncImage(
                            model = characters[it]?.image,
                            contentDescription = characters[it]?.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth().height(60.dp).background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Black.copy(0F),
                                        Color.Black.copy(0.6F),
                                        Color.Black.copy(1F),
                                    ),
                                )
                            ),
                            contentAlignment = Alignment.Center,

                            ) {
                            Text(
                                text = characters[it]?.name ?: "",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
        }
    }
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