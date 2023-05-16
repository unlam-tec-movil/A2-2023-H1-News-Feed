package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.news.ExampleNew

@Preview(showBackground = true)
@Composable
fun ArticleCard() {
}

@Composable
fun CardContainer(new: ExampleNew) {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text = new.topic)
        Text(
            text = new.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = new.date)
        Divider()
    }
}
