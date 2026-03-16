package reservation

import reservation.discount.policy.DiscountPolicy
import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    private val discountPolicy: DiscountPolicy
) {

    fun calculateMovieFee(screening: Screening): Money =
        fee - discountPolicy.calculateDiscountAmount(screening)
}