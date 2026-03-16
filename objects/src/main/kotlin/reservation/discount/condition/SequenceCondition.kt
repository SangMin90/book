package reservation.discount.condition

import reservation.Screening

class SequenceCondition(
    private val sequence: Int
): DiscountCondition {

    override fun isSatisfied(screening: Screening): Boolean {
        return screening.isSequence(this.sequence)
    }
}