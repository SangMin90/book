package sale.ver1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TicketOfficeTest : BehaviorSpec({

    given("매표소에 1장 이상의 티켓이 있을 때") {
        val ticket1 = Ticket(fee = 10_000L)
        val ticket2 = Ticket(fee = 10_000L)

        val sut = TicketOffice(
            amount = 10_000L,
            ticket1,
            ticket2,
        )

        `when`("티켓을 꺼내면") {
            val ticket = sut.ticket
            val ticketCount = sut.ticketCount

            then("티켓이 한장 감소한다.") {
                ticket shouldBe ticket1
                ticketCount shouldBe 1
            }
        }
    }

    given("매표소에서 구만원을 보유하고 있을 때") {

        val sut = TicketOffice(
            amount = 90_000L,
        )

        `when`("만원을 더하면") {
            val amount = sut.plusAmount(10_000L)

            then("보유 금액이 만원 증가한다.") {
                amount shouldBe 100_000L
            }
        }
    }

    given("매표소에서 십일만원을 보유하고 있을 때") {

        val sut = TicketOffice(
            amount = 110_000L,
        )

        `when`("만원을 차감하면") {
            val amount = sut.minusAmount(10_000L)

            then("보유 금액이 만원 감소한다.") {
                amount shouldBe 100_000L
            }
        }
    }
})