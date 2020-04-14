package pl.pawel.kul.service;

import org.junit.jupiter.api.Test;
import pl.pawel.kul.model.FunctionOne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DecodingMessageTest {

    @Test
    void shouldResultNewSyndrome() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001110");
        //when
        int[] ints = decodingMessage.calculateNewSyndrome();
        //then
        assertArrayEquals(ints,new int[]{1,1,0});
    }

    @Test
    void shouldResultOldSyndrome() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001110");
        //when
        int[] ints = decodingMessage.calculateOldSyndrome();
        //then
        assertArrayEquals(ints,new int[]{1,1,0});
    }

    @Test
    void shouldXorCalculateThanNewSyndromeEqualOldSyndromeResult() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001110");
        //when
        int[] ints = decodingMessage.xorResultSyndromeOldSyndrome();
        //then
        assertArrayEquals(ints,new int[]{0,0,0});
    }

    @Test
    void shouldXorCalculateThanNewSyndromeNotEqualOldSyndromeResult() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1011110");
        //when
        int[] ints = decodingMessage.xorResultSyndromeOldSyndrome();
        //then
        assertArrayEquals(ints,new int[]{1,1,0});
    }

    @Test
    void shouldValidMessage() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001110");
        //when
        boolean valid = decodingMessage.validXor();
        //then
        assertThat(valid).isTrue();
    }

    @Test
    void shouldNotValidMessage() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1011110");
        //when
        boolean valid = decodingMessage.validXor();
        //then
        assertThat(valid).isFalse();
    }

    @Test
    void shouldGetErrorBit() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1011110");
        //when
        int errorBit = decodingMessage.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(3);
    }

    @Test
    void shouldGetErrorBit0() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001110");
        //when
        int errorBit = decodingMessage.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(0);
    }

    @Test
    void shouldGetErrorBit2() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1101110");
        //when
        int errorBit = decodingMessage.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(2);
    }

    @Test
    void shouldGetErrorBit4() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1000110");
        //when
        int errorBit = decodingMessage.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(4);
    }

    @Test
    void shouldGetErrorBit6() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001100");
        //when
        int errorBit = decodingMessage.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(6);
    }

    @Test
    void shouldGetErrorBit7() {
        //given
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001111");
        //when
        int errorBit = decodingMessage.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(7);
    }

    @Test
    void shouldFillVectorZeroErrorOn2Bit() {
        DecodingMessage decodingMessage=new DecodingMessage(new FunctionOne(),"1001111");
        int test[]={0,1,0,0,0,0,0};
        //when
        int[] ints = decodingMessage.fillVectorZeroErrorBit(2);
        //then
        assertThat(test).isEqualTo(ints);
    }


}