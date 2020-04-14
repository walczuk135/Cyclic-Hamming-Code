package pl.pawel.kul.service;

import org.junit.jupiter.api.Test;
import pl.pawel.kul.model.FunctionOne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CodingMessageTest {
    @Test
    void shouldCodingMessageThatFunctionOneExample1() {
        //given
        String message="1001";
        CodingMessage codingMessage=new CodingMessage(new FunctionOne(),message);
        //when
        String codingResult = codingMessage.coding();
        //then
        assertThat(codingResult).isEqualTo("1001110");
    }

    @Test
    void shouldCodingMessageThatFunctionOneExample2() {
        //given
        String message="1110";
        CodingMessage codingMessage=new CodingMessage(new FunctionOne(),message);
        //when
        String codingResult = codingMessage.coding();
        //then
        assertThat(codingResult).isEqualTo("1110100");
    }
}