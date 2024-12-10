package com.victor.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victor.nearby.R
import com.victor.nearby.data.model.Market
import com.victor.nearby.data.model.mock.mockMarkets
import com.victor.nearby.ui.theme.Gray500
import com.victor.nearby.ui.theme.NearbyTheme
import com.victor.nearby.ui.theme.Typography

@Composable
fun NearbyMarketDetailsInfo(modifier: Modifier = Modifier, market: Market) {

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Text(text = "Informações", style = Typography.headlineSmall)

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_ticket),
                    contentDescription = "Ícone de cupom",
                    tint = Gray500
                )
                Text(
                    text = "${market.coupons} cupons disponíveis",
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_map_pin),
                    contentDescription = "Ícone de localização",
                    tint = Gray500
                )
                Text(
                    text = market.address,
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_phone),
                    contentDescription = "Ícone de telefone",
                    tint = Gray500
                )
                Text(
                    text = market.phone,
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NearbyMarketDetailsInfoPreview() {
    NearbyTheme {
        NearbyMarketDetailsInfo(
            modifier = Modifier.fillMaxWidth(),
            market = mockMarkets.first()
        )
    }
}