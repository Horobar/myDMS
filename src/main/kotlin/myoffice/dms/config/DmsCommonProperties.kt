package myoffice.dms.config

import myoffice.dms.config.DmsCommonProperties.Companion.PREFIX
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(PREFIX)
class DmsCommonProperties(
    /**
     * Path where the Filesystem starts
     */
    val home: String,
    /**
     * Folder where the fresh scanned files are saved
     */
    val fileIn: String
) {
    companion object {
        const val PREFIX = "${CONFIG_PREFIX}.dms"
    }
    val pathToFileIn = "$home$fileIn"


}
