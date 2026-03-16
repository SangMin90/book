package reservation.discount.policy

import reservation.Money
import reservation.Screening

interface DiscountPolicy {

    fun calculateDiscountAmount(
        screening: Screening
    ): Money
}