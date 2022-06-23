package no.nav

import no.nav.db.Database
import no.nav.quizrapid.*
import no.nav.rapid.Assessment
import no.nav.rapid.Question


/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String, database: Database? = null): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)
        if (question.category == "team-registration") handleRegisterTeam(question)
        if (question.category == "arithmetic") handleArithmeticQuestion(question)
        if (question.category == "make-ingress") handleIngressQuestion(question)
        if (question.category == "NAV") handleNAVQuestion(question)

    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    /**
     * Spørsmål handlers
     */

    private fun handleRegisterTeam(question: Question) {
        answer(question.category, question.id(), "tania")
    }

    private fun handleArithmeticQuestion(question: Question) {
        val message = question.question
        val splitMessage = message.split(" ")
        if(splitMessage[1] == "+") {
            val res = splitMessage[0].toInt() + splitMessage[2].toInt()
            answer(question.category, question.id(), res.toString())
        } else if (splitMessage[1] == "-") {
            val res = splitMessage[0].toInt() - splitMessage[2].toInt()
            answer(question.category, question.id(), res.toString())
        } else if (splitMessage[1] == "/") {
            val res = splitMessage[0].toInt() / splitMessage[2].toInt()
            answer(question.category, question.id(), res.toString())
        } else if (splitMessage[1] == "*") {
            val res = splitMessage[0].toInt() * splitMessage[2].toInt()
            answer(question.category, question.id(), res.toString())
    }
}

    private fun handleIngressQuestion(question: Question) {
        answer(question.category, question.id(), "https://tania.dev.intern.nav.no")
        }

    private fun handleNAVQuestion(question: Question) {
        answer(question.category, question.id(), "https://https://www.detsombetyrnoe.no")
    }

}