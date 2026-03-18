package reservation

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDateTime

class ScreeningTest : BehaviorSpec({

    given("첫번째 상영일 때") {
        val stubMovie = mockk<Movie>()
        val sut = Screening(
            movie = stubMovie,
            1,
            LocalDateTime.now()
        )

        `when`("동일한 순번인 1이 주어지면") {
            val result = sut.isSequence(1)

            then("true를 반환한다.") {
                result shouldBe true
            }
        }

        `when`("1이 아닌 다른 순번이 주어지면") {
            val result = sut.isSequence(2)

            then("false를 반환한다.") {
                result shouldBe false
            }
        }
    }

    given("1인 관람비 10000원인 영화를 상영할 때") {
        val customer = mockk<Customer>()
        val stubMovie = mockk<Movie>()
        every {
            stubMovie.calculateMovieFee(any())
        } returns Money.wons(10_000L)

        val sut = Screening(
            movie = stubMovie,
            1,
            LocalDateTime.now()
        )

        `when`("2명을 예약하면") {
            val reservation = sut.reserve(customer, 2)

            then("총 금액은 20,000원이다.") {
                reservation.fee shouldBe Money.wons(20_000L)
            }
        }
    }
})