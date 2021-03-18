package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("로또 발급")
    public void createLottoTicket() throws Exception {
        //given
        List<Integer> numbers = createLottoNumber();
        LottoTicket lottoTicket = new LottoTicket(numbers);

        //when

        //then
        assertThat(lottoTicket.lottoNumber()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또 번호 6개인지 확인")
    public void checkLottoNumberSize() throws Exception {
        //given
        LottoTicket lottoTicket = new LottoTicket();

        //when
        List<Integer> numbers = lottoTicket.lottoNumber();

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }
}
