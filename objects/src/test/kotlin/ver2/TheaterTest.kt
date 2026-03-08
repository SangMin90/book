package ver2

import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class TheaterTest {

    private val ticketSeller = mockk<TicketSeller>(relaxed = true)
    private lateinit var sut: Theater
    
    @Test
    fun `enter 호출 시 TicketSeller에게 판매 요청을 전달한다_enter    `() {
        sut = Theater(ticketSeller)
        val audience = mockk<Audience>()

        sut.enter(audience)

        verify { ticketSeller.sellTo(audience) }
    }
}