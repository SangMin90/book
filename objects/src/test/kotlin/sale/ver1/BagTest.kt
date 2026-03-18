package sale.ver1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk

class BagTest : BehaviorSpec({

    given("가방에 초대장이 있을 때") {
        val stubInvitation = mockk<Invitation>()
        val sut = Bag(
            amount = 10_000L,
            invitation = stubInvitation
        )

        `when`("초대장 소지 여부를 검사하면") {
            val result = sut.hasInvitation

            then("true를 반환한다.") {
                result shouldBe true
            }
        }
    }

    given("가방에 초대장이 없을 때") {
        val sut = Bag(amount = 10_000L)

        `when`("초대장 소지 여부를 검사하면") {
            val result = sut.hasInvitation

            then("false를 반환한다.") {
                result shouldBe false
            }
        }
    }

    given("가방에 티켓이 없을 때") {
        val sut = Bag(amount = 10_000L)

        `when`("티켓 소지 여부를 검사하면") {
            val result = sut.hasTicket

            then("false를 반환한다.") {
                result shouldBe false
            }
        }
    }

    given("가방에 티켓이 있을 때") {
        val stubTicket = mockk<Ticket>()
        val sut = Bag(
            amount = 10_000L,
            ticket = stubTicket
        )

        `when`("티켓 소지 여부를 검사하면") {
            val result = sut.hasTicket

            then("true를 반환한다.") {
                result shouldBe true
            }
        }
    }

    given("가방에 만원이 있을 때") {
        val sut = Bag(amount = 10_000L)

        `when`("1000원을 넣으면") {
            val result = sut.plusAmount(1_000L)

            then("11000원을 반환한다.") {
                result shouldBe 11_000L
            }
        }
    }

    given("가방에 만천원이 있을 때") {
        val sut = Bag(amount = 11_000L)

        `when`("천원을 차감하면") {
            val result = sut.minusAmount(1_000L)

            then("만원을 반환한다.") {
                result shouldBe 10_000L
            }
        }
    }
})