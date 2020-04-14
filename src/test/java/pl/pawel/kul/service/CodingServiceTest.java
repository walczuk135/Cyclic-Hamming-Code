package pl.pawel.kul.service;

import org.junit.jupiter.api.Test;
import pl.pawel.kul.model.FunctionOne;

import static org.assertj.core.api.Assertions.assertThat;

class CodingServiceTest {
    @Test
    void shouldCodingMessageThatFunctionOneExample1() {
        //given
        String message="1001";
        CodingService codingService =new CodingService(new FunctionOne(),message);
        //when
        String codingResult = codingService.coding();
        //then
        assertThat(codingResult).isEqualTo("1001110");
    }

    @Test
    void shouldCodingMessageThatFunctionOneExample2() {
        //given
        String message="1110";
        CodingService codingService =new CodingService(new FunctionOne(),message);
        //when
        String codingResult = codingService.coding();
        //then
        assertThat(codingResult).isEqualTo("1110100");
    }
}