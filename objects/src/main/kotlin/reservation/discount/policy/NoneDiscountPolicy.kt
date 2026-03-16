package reservation.discount.policy

import reservation.Money
import reservation.Screening

class NoneDiscountPolicy: DiscountPolicy {

    override fun calculateDiscountAmount(
        screening: Screening
    ): Money = Money.ZERO
}