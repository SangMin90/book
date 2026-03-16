package reservation.discount.condition

import reservation.Screening

interface DiscountCondition {
    fun isSatisfied(screening: Screening): Boolean
}
