package reservation.discount.policy

import reservation.Money
import reservation.Screening
import reservation.discount.condition.DiscountCondition

abstract class DefaultDiscountPolicy(
    vararg discountCondition: DiscountCondition
) : DiscountPolicy {
    private val conditions: List<DiscountCondition> =
        discountCondition.toList()

    override fun calculateDiscountAmount(
        screening: Screening
    ): Money {

        val isSatisfied: Boolean = conditions.any {
            it.isSatisfied(screening)
        }

        return if (isSatisfied) {
            getDiscountAmount(screening)
        } else {
            Money.ZERO
        }
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}