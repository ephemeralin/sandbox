package strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * The Strings transformer test.
 */
public class StringsTransformerTest {

    /**
     * First letter upper case.
     */
    @Test
    public void firstLetterUpperCaseTest() {
        assertThat(StringsTransformer.firstLettersGetCapital("ИВАнов иВан иваНОВИЧ"),
                is("Иванов Иван Иванович"));

    }
}