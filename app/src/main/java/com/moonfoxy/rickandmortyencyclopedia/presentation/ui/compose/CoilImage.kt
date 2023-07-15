package com.moonfoxy.rickandmortyencyclopedia.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.moonfoxy.rickandmortyencyclopedia.R

class ImageUrlProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf("")
}

@Preview
@Composable
fun CoilImage(
    @PreviewParameter(ImageUrlProvider::class) imageUrl: String
) {
    if (LocalInspectionMode.current) {
        Image(
            painter = painterResource(id = R.drawable.rick),
            contentDescription = "Coil Image",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(4.dp))
        )
    } else {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Coil Image",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(4.dp))
        )
    }
}