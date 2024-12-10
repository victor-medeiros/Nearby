package com.victor.nearby.ui.component.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victor.nearby.data.model.Market
import com.victor.nearby.data.model.mock.mockMarkets
import com.victor.nearby.ui.theme.NearbyTheme
import com.victor.nearby.ui.theme.Typography

@Composable
fun NearbyMarkerCardList(
    modifier: Modifier = Modifier,
    markets: List<Market>,
    onMarketClick: (Market) -> Unit
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Explore locais perto de você", style = Typography.bodyLarge)
        }

        items(markets, key = { it.id }) { market ->
            NearbyMarketCard(market = market, onClick = { onMarketClick(market) })
        }
    }
}

@Preview
@Composable
private fun NearbyMarkerCardListPreview() {
    NearbyTheme {
        NearbyMarkerCardList(
            markets = mockMarkets,
            onMarketClick = {}
        )
    }
}