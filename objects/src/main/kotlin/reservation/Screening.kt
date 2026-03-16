package reservation

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    val startTime: LocalDateTime
        get() = whenScreened

    val movieFee: Money
        get() = movie.fee

    fun isSequence(sequence: Int): Boolean =
        this.sequence == sequence

    fun reserve(
        customer: Customer,
        audienceCount: Long
    ) = Reservation(
        customer = customer,
        screening = this,
        fee = calculateFee(audienceCount),
        audienceCount = audienceCount
    )

    private fun calculateFee(
        audienceCount: Long
    ): Money = movie.calculateMovieFee(this) * audienceCount
}