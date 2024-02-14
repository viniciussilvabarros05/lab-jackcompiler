package br.ufma.ecp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import br.ufma.ecp.token.Token;
import br.ufma.ecp.token.TokenType;



public class ParserTest extends TestSupport {

    @Test
    public void testParseTermInteger () {
      var input = "10;";
      var parser = new Parser(input.getBytes(StandardCharsets.UTF_8));
      parser.parseTerm();
      var expectedResult =  """
        <term>
        <integerConstant> 10 </integerConstant>
        </term>
        """;

        var result = parser.XMLOutput();
        expectedResult = expectedResult.replaceAll("  ", "");
        result = result.replaceAll("\r", ""); // no codigo em linux não tem o retorno de carro
        assertEquals(expectedResult, result);    

    }


    @Test
    public void testParseTermIdentifer() {
        var input = "varName;";
        var parser = new Parser(input.getBytes(StandardCharsets.UTF_8));
        parser.parseTerm();

        var expectedResult =  """
          <term>
          <identifier> varName </identifier>
          </term>
          """;

          var result = parser.XMLOutput();
          expectedResult = expectedResult.replaceAll("  ", "");
          result = result.replaceAll("\r", ""); // no codigo em linux não tem o retorno de carro
          assertEquals(expectedResult, result);    

    }



    @Test
    public void testParseTermString() {
        var input = "\"Hello World\"";
        var parser = new Parser(input.getBytes(StandardCharsets.UTF_8));
        parser.parseTerm();

        var expectedResult =  """
          <term>
          <stringConstant> Hello World </stringConstant>
          </term>
          """;

          var result = parser.XMLOutput();
          expectedResult = expectedResult.replaceAll("  ", "");
          result = result.replaceAll("\r", ""); // no codigo em linux não tem o retorno de carro
          assertEquals(expectedResult, result);    

    }


}