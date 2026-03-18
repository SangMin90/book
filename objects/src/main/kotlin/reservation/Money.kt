package reservation

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money(
    private val amount: BigDecimal
) {

    companion object {

        val ZERO: Money = wons(0)

        fun wons(amount: Long): Money =
            Money(BigDecimal(amount))
    }

    operator fun plus(amount: Money): Money =
        Money(this.amount.add(amount.amount))

    operator fun minus(amount: Money): Money =
        Money(
            this.amount.subtract(amount.amount)
        )

    operator fun times(amount: Long): Money =
        Money(
            this.amount.multiply(
                BigDecimal.valueOf(amount)
            )
        )

    operator fun times(percent: Double): Money =
        Money(
            this.amount.multiply(
                BigDecimal.valueOf(percent)
            ).setScale(0, RoundingMode.DOWN)
        )
}
