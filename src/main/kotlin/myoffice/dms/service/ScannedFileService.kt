package myoffice.dms.service

import myoffice.dms.model.FileModel
import myoffice.dms.config.DmsCommonProperties
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
import kotlin.io.path.name
import kotlin.io.path.pathString

@Service
class ScannedFileService(
    private val dmsCommonProperties: DmsCommonProperties
) {
    val path= Paths.get(dmsCommonProperties.pathToFileIn)

    fun listFiles(): List<FileModel>{
        val fileDirMap: List<FileModel>
        if(Files.isDirectory(path)){
            fileDirMap = Files.list(path)
                .collect(Collectors.toList())
                .map { FileModel(it.name, it.pathString, Files.readString(it)) }
        } else {
            throw Exception()
        }
        return fileDirMap
    }
}