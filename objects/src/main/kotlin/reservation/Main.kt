package reservation

import reservation.discount.condition.PeriodCondition
import reservation.discount.condition.SequenceCondition
import reservation.discount.policy.AmountDiscountPolicy
import reservation.discount.policy.PercentDiscountPolicy
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime

fun main() {
    val avatar = Movie(
        "Avatar",
        Duration.ofMinutes(120),
        Money.wons(10_000L),
        AmountDiscountPolicy(
            Money.wons(800L),
            SequenceCondition(1),
            SequenceCondition(10),
            PeriodCondition(
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0),
            ),
            PeriodCondition(
                DayOfWeek.THURSDAY,
                LocalTime.of(18, 0),
                LocalTime.of(21, 0),
            )
        ),
    )

    Movie(
        "Titanic",
        Duration.ofMinutes(100),
        Money.wons(11_000L),
        PercentDiscountPolicy(
            0.1,
            PeriodCondition(
                DayOfWeek.TUESDAY,
                LocalTime.of(14, 0),
                LocalTime.of(17, 0)
            ),
            SequenceCondition(2),
            PeriodCondition(
                DayOfWeek.THURSDAY,
                LocalTime.of(10, 0),
                LocalTime.of(14, 0),
            )
        )
    )
}