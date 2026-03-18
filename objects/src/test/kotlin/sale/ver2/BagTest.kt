package sale.ver2

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class BagTest : BehaviorSpec({

    given("가방에 티켓이 있을 때") {
        val sut = Bag(
            amount = 1L,
            ticket = Ticket(10_000L)
        )

        `when`("티켓 소유 여부를 검사하면") {
            val hasTicket = sut.hasTicket

            then("true를 반환한다.") {
                hasTicket shouldBe true
            }
        }
    }

    given("가방에 티켓이 없을 때") {
        val sut = Bag(amount = 1L)

        `when`("티켓 소유 여부를 검사하면") {
            val hasTicket = sut.hasTicket

            then("false를 반환한다.") {
                hasTicket shouldBe false
            }
        }
    }

    given("가방에 초대장이 있을 때") {
        val sut = Bag(
            amount = 1L,
            invitation = Invitation(
                LocalDateTime.now()
            )
        )

        `when`("초대장 소유 여부를 검사하면") {
            val hasInvitation = sut.hasInvitation

            then("true를 반환한다.") {
                hasInvitation shouldBe true
            }
        }
    }

    given("가방에 초대장이 없을 때") {
        val sut = Bag(amount = 1L)

        `when`("초대장 소유 여부를 검사하면") {
            val hasInvitation = sut.hasInvitation

            then("false를 반환한다.") {
                hasInvitation shouldBe false
            }
        }
    }

    given("가방에 구만원이 있을 때") {
        val sut = Bag(90_000L)

        `when`("만원을 넣으면") {
            val amount = sut.plusAmount(10_000L)

            then("십만원이 된다.") {
                amount shouldBe 100_000L
            }
        }
    }

    given("가방에 십일만원이 있을 때") {
        val sut = Bag(110_000L)

        `when`("만원을 차감하면") {
            val amount = sut.minusAmount(10_000L)

            then("십만원이 된다.") {
                amount shouldBe 100_000L
            }
        }
    }
})