package pl.pawel.kul.service;

import org.junit.jupiter.api.Test;
import pl.pawel.kul.model.FunctionOne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DecodingServiceTest {

    @Test
    void shouldResultNewSyndrome() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001110");
        //when
        int[] ints = decodingService.calculateNewSyndrome();
        //then
        assertArrayEquals(ints,new int[]{1,1,0});
    }

    @Test
    void shouldResultOldSyndrome() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001110");
        //when
        int[] ints = decodingService.calculateOldSyndrome();
        //then
        assertArrayEquals(ints,new int[]{1,1,0});
    }

    @Test
    void shouldXorCalculateThanNewSyndromeEqualOldSyndromeResult() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001110");
        //when
        int[] ints = decodingService.xorResultSyndromeOldSyndrome();
        //then
        assertArrayEquals(ints,new int[]{0,0,0});
    }

    @Test
    void shouldXorCalculateThanNewSyndromeNotEqualOldSyndromeResult() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1011110");
        //when
        int[] ints = decodingService.xorResultSyndromeOldSyndrome();
        //then
        assertArrayEquals(ints,new int[]{1,1,0});
    }

    @Test
    void shouldValidMessage() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001110");
        //when
        boolean valid = decodingService.validXor();
        //then
        assertThat(valid).isTrue();
    }

    @Test
    void shouldNotValidMessage() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1011110");
        //when
        boolean valid = decodingService.validXor();
        //then
        assertThat(valid).isFalse();
    }

    @Test
    void shouldGetErrorBit() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1011110");
        //when
        int errorBit = decodingService.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(3);
    }

    @Test
    void shouldGetErrorBit0() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001110");
        //when
        int errorBit = decodingService.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(0);
    }

    @Test
    void shouldGetErrorBit2() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1101110");
        //when
        int errorBit = decodingService.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(2);
    }

    @Test
    void shouldGetErrorBit4() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1000110");
        //when
        int errorBit = decodingService.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(4);
    }

    @Test
    void shouldGetErrorBit6() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001100");
        //when
        int errorBit = decodingService.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(6);
    }

    @Test
    void shouldGetErrorBit7() {
        //given
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001111");
        //when
        int errorBit = decodingService.calculateErrorBit();
        //then
        assertThat(errorBit).isEqualTo(7);
    }

    @Test
    void shouldFillVectorZeroErrorOn2Bit() {
        DecodingService decodingService =new DecodingService(new FunctionOne(),"1001111");
        int test[]={0,1,0,0,0,0,0};
        //when
        int[] ints = decodingService.fillVectorZeroErrorBit(2);
        //then
        assertThat(test).isEqualTo(ints);
    }


}