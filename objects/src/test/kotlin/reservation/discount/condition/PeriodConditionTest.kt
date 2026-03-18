package reservation.discount.condition

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import reservation.Screening
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

class PeriodConditionTest : BehaviorSpec({

    given("월요일 10 ~ 14시 사이에 상영일 때") {
        val stubScreening: Screening = mockk<Screening>()
        every { stubScreening.startTime } returns
                LocalDateTime.of(
                    2026, 3, 16, 11, 0, 0
                )

        val sut = PeriodCondition(
            dayOfWeek = DayOfWeek.MONDAY,
            startTime = LocalTime.of(10, 0),
            endTime = LocalTime.of(14, 0)
        )

        `when`("할인 조건을 검사하면") {
            val result = sut.isSatisfied(stubScreening)

            then("할인 조건을 만족한다.") {
                result shouldBe true
            }
        }
    }

    given("월요일 10 ~ 14시 이외 상영일 때") {
        val screening: Screening = mockk<Screening>()
        every { screening.startTime } returns
                LocalDateTime.of(
                    2026, 3, 16, 17, 0, 0
                )

        val sut = PeriodCondition(
            dayOfWeek = DayOfWeek.MONDAY,
            startTime = LocalTime.of(10, 0),
            endTime = LocalTime.of(14, 0)
        )

        `when`("할인 조건을 검사하면") {
            val result = sut.isSatisfied(screening)

            then("할인 조건을 만족한다.") {
                result shouldBe false
            }
        }
    }
})