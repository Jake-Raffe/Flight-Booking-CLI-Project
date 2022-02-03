import org.jetbrains.annotations.TestOnly;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;

public class Testing {

    @Test
    void example(){
        int result = 4+3;
        assertThat(result).isEqualTo(7);
    }

}
