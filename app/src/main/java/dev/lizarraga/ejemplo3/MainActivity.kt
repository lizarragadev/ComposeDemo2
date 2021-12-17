package dev.lizarraga.ejemplo3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.lizarraga.ejemplo3.model.Speaker
import dev.lizarraga.ejemplo3.ui.theme.Ejemplo3Theme
import dev.lizarraga.ejemplo3.uibase.SpeakerCard
import dev.lizarraga.ejemplo3.viewmodel.SpeakerViewModel

class MainActivity : ComponentActivity() {

    private val speakerView: SpeakerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo3Theme {
                ShowList()
            }
        }
    }

    @Composable
    fun ShowList() {
        val speakerData = speakerView.speakerList.value
        speakerData?.let { SetSpeakerList(speakerList = it) }
    }

    @Composable
    fun SetSpeakerList(speakerList: List<Speaker>) {
        LazyColumn {
            itemsIndexed(items = speakerList) { index, itemSpeaker ->
                SpeakerCard(speaker = itemSpeaker, onClick = {
                    Toast.makeText(applicationContext,
                        "Hizo click en: ${itemSpeaker.name}",
                        Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ejemplo3Theme {

    }
}