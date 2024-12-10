package com.victor.nearby.ui.component.market_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victor.nearby.R
import com.victor.nearby.ui.theme.GreenBase
import com.victor.nearby.ui.theme.GreenExtraLight
import com.victor.nearby.ui.theme.NearbyTheme
import com.victor.nearby.ui.theme.Typography

@Composable
fun NearbyMarketDetailsCoupons(
    modifier: Modifier = Modifier,
    coupons: List<String>
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Utilize esse cupom", style = Typography.headlineSmall)

        coupons.forEach { coupon ->

            Row(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenExtraLight)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.ic_ticket),
                    contentDescription = "Ícone cupons",
                    tint = GreenBase
                )

                Text(text = coupon, style = Typography.headlineSmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NearbyMarketDetailsCouponsPreview() {
    NearbyTheme {
        NearbyMarketDetailsCoupons(
            modifier = Modifier.fillMaxWidth(),
            coupons = listOf("FM4345T6", "FM4345T7")
        )
    }
}