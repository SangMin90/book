package reservation.discount.policy

import reservation.Money
import reservation.Screening
import reservation.discount.condition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    vararg discountCondition: DiscountCondition
): DefaultDiscountPolicy(*discountCondition) {

    override fun getDiscountAmount(
        screening: Screening
    ): Money = discountAmount
}