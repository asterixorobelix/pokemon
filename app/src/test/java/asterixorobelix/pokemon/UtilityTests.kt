package asterixorobelix.pokemon

import com.google.common.truth.Truth
import org.junit.Test

class UtilityTests {

    @Test
    fun `confirm pokemon index handling null`() {
        Truth.assertThat(getAPIIndex(null)).isEqualTo(1)
    }

    @Test
    fun `confirm pokemon index handling non null`() {
        Truth.assertThat(getAPIIndex(2)).isEqualTo(3)
    }
}