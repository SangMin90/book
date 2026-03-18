package reservation.discount.condition

import reservation.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) : DiscountCondition {

    override fun isSatisfied(
        screening: Screening
    ): Boolean {

        val time = screening.startTime.toLocalTime()

        return screening.startTime.dayOfWeek == dayOfWeek &&
                !time.isBefore(startTime) &&
                !time.isAfter(endTime)
    }
}