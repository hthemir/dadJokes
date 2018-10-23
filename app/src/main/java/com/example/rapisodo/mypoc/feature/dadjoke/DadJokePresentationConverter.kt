package com.example.rapisodo.mypoc.feature.dadjoke

import com.example.rapisodo.mypoc.data.model.presentation.DadJokePresentation
import com.example.rapisodo.mypoc.data.model.service.CharadaResponse
import com.example.rapisodo.mypoc.data.model.service.DadJokeResponse
import javax.inject.Inject

open class DadJokePresentationConverter @Inject constructor() {
    open fun convert(dadJokeResponse: DadJokeResponse) : DadJokePresentation {
        val dadJokeId = dadJokeResponse.id ?: ""
        val dadJoke = dadJokeResponse.joke ?: "why was 6 afraid of 7? because 7 8 9"
        val dadJokeStatus = dadJokeResponse.status ?: 404

        return DadJokePresentation(dadJokeId, dadJoke, dadJokeStatus)
    }

    open fun convertCharada(charadaResponse: CharadaResponse) : DadJokePresentation {
        val charadaId = charadaResponse.id ?: ""
        val charadaQuestion = charadaResponse.pergunta ?: "why was 6 afraid of 7?"
        val charadaAnswer = charadaResponse.resposta ?: "because 7 8 9"
        val charadaQA = charadaQuestion + "\n" + charadaAnswer
        val charadaStatus = 200

        return DadJokePresentation(charadaId, charadaQA, charadaStatus)
    }
}