package sale.ver2

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class TicketOfficeTest : BehaviorSpec({

    given("매표소에 한장 이상의 티켓이 있을 때") {
        val stubAudience = mockk<Audience>()
        every { stubAudience.buy(any()) } returns 0L

        val ticket1 = Ticket(fee = 10_000L)
        val ticket2 = Ticket(fee = 10_000L)
        val sut = TicketOffice(
            amount = 100_000L,
            ticket1,
            ticket2,
        )

        `when`("한명의 관람객에게 티켓을 판매하면") {
            sut.sellTicketTo(stubAudience)

            then("티켓이 줄고 보유 금액이 증가한다.") {
                sut.ticketCount shouldBe 1
                sut.currentAmount shouldBe 110_000L
            }
        }
    }
})