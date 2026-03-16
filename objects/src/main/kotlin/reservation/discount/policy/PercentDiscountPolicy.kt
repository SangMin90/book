package reservation.discount.policy

import reservation.Money
import reservation.Screening
import reservation.discount.condition.DiscountCondition

class PercentDiscountPolicy(
    private val percent: Double,
    vararg discountCondition: DiscountCondition
): DefaultDiscountPolicy(*discountCondition) {

    override fun getDiscountAmount(
        screening: Screening
    ): Money = screening.movieFee * percent
}