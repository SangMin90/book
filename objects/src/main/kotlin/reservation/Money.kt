package reservation

import java.math.BigDecimal

@JvmInline
value class Money(
    private val amount: BigDecimal
) {

    companion object {

        val ZERO: Money = wons(0)

        fun wons(amount: Long): Money = Money(BigDecimal(amount))
    }

    operator fun plus(amount: Long): Money =
        Money(this.amount.add(BigDecimal.valueOf(amount)))

    operator fun minus(amount: Money): Money =
        Money(this.amount.subtract(amount.amount))

    operator fun times(amount: Long): Money =
        Money(this.amount.multiply(BigDecimal.valueOf(amount)))

    operator fun times(amount: Double): Money =
        Money(this.amount.multiply(BigDecimal.valueOf(amount)))
}
