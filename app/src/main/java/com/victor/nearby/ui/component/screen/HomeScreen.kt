package com.victor.nearby.ui.component.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.maps.android.compose.GoogleMap
import com.victor.nearby.data.model.Market
import com.victor.nearby.data.model.mock.mockCategories
import com.victor.nearby.data.model.mock.mockMarkets
import com.victor.nearby.ui.component.category.NearbyCategoryChipList
import com.victor.nearby.ui.component.market.NearbyMarkerCardList
import com.victor.nearby.ui.theme.Gray100
import com.victor.nearby.ui.theme.NearbyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateToMarketDetails: (Market) -> Unit) {
    val bottomSheetState = rememberBottomSheetScaffoldState()
    var isBottomSheetOpened by remember { mutableStateOf(true) }

    val configuration = LocalConfiguration.current

    if (isBottomSheetOpened) {
        BottomSheetScaffold(
            modifier = modifier,
            scaffoldState = bottomSheetState,
            sheetContainerColor = Gray100,
            sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                NearbyMarkerCardList(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    markets = mockMarkets,
                    onMarketClick = onNavigateToMarketDetails
                )
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    GoogleMap(modifier = Modifier.fillMaxSize())
                    NearbyCategoryChipList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                            .align(Alignment.TopStart),
                        categories = mockCategories,
                        onSelectedCategoryChanged = {}
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    NearbyTheme {
        HomeScreen(onNavigateToMarketDetails = {})
    }
}