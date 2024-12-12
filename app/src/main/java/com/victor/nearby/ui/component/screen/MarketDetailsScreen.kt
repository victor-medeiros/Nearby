package com.victor.nearby.ui.component.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.victor.nearby.R
import com.victor.nearby.data.model.Market
import com.victor.nearby.data.model.mock.mockMarkets
import com.victor.nearby.ui.component.button.NearbyButton
import com.victor.nearby.ui.component.market_details.NearbyMarketDetailsCoupons
import com.victor.nearby.ui.component.market_details.NearbyMarketDetailsInfo
import com.victor.nearby.ui.theme.NearbyTheme
import com.victor.nearby.ui.theme.Typography

@Composable
fun MarketDetailsScreen(
    modifier: Modifier = Modifier,
    market: Market,
    onNavigateBack: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            model = market.cover,
            contentDescription = "Imagem do local",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(36.dp)
            ) {
                Column {
                    Text(text = market.name, style = Typography.headlineLarge)
                    Spacer(Modifier.height(16.dp))
                    Text(text = market.description, style = Typography.bodyLarge)
                }
                Spacer(Modifier.height(48.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    NearbyMarketDetailsInfo(market = market)

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 24.dp)
                    )

//                    if (market.rules.isNotEmpty()) {
//                        NearbyMarketDetailsRules(rules = market.rules)
//                        HorizontalDivider(
//                            modifier = Modifier
//                                .fillMaxHeight()
//                                .padding(vertical = 24.dp)
//                        )
//                    }

                    NearbyMarketDetailsCoupons(coupons = listOf("ABC12345"))
                }

                NearbyButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    text = "Ler QR Code",
                    onClick = {}
                )
            }

        }
        NearbyButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigateBack
        )
    }
}

@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    NearbyTheme {
        MarketDetailsScreen(
            market = mockMarkets.first(),
            onNavigateBack = {}
        )
    }
}