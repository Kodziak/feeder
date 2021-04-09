package com.example.feeder.ui.events

import com.example.feeder.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

object SampleContent {
    val ITEMS: MutableList<EventModel> = ArrayList()

    private val ids = listOf(
        "Example blog post 1",
        "Example blog post 2",
        "Example blog post 3",
        "Example blog post 4"
    )
    private val description = listOf(
        "Example blog description 1",
        "Example blog description 2",
        "Example blog description 3",
        "Example blog description 4"
    )

    init {
        for (i in 0..4) {
            ITEMS.add(generateEvent())
        }

    }

    private fun generateEvent(): EventModel {
        val id = ids.random()
        val image = R.drawable.ic_baseline_rss_feed_24
        val description = description.random()

        return EventModel(id, image, description)
    }

    data class EventModel(
        val id: String,
        val image: Int,
        val description: String
    )
}