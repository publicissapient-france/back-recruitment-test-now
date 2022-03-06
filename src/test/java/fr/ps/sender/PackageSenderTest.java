package fr.ps.sender;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PackageSenderTest {

    @Test
    @DisplayName("a boolean assertion")
    public void hello() {
        var message = """
            hello, java 16
                """;
        System.out.println(message);
        assertThat(true).isEqualTo(true);
    }
}
