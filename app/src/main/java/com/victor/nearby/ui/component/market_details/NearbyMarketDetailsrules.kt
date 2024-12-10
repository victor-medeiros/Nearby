package com.victor.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victor.nearby.data.model.Rule
import com.victor.nearby.data.model.mock.mockRules
import com.victor.nearby.ui.theme.Gray400
import com.victor.nearby.ui.theme.Gray500
import com.victor.nearby.ui.theme.NearbyTheme
import com.victor.nearby.ui.theme.Typography

@Composable
fun NearbyMarketDetailsRules(
    modifier: Modifier = Modifier,
    rules: List<Rule>
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = rules.joinToString(separator = "\n") { "• ${it.description}" },
            style = Typography.labelMedium,
            color = Gray500,
            lineHeight = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NearbyMarketDetailsRulesPreview() {
    NearbyTheme {
        NearbyMarketDetailsRules(modifier = Modifier.fillMaxWidth(), rules = mockRules)
    }
}