package com.learnwy.system.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException

class FileUtils {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(FileUtils::class.java);
        fun createFileIfNoExists(fileName: String): Boolean {
            var isCreate: Boolean = true;
            try {
                java.nio.file.Files.createFile(java.nio.file.Paths.get(fileName));
            } catch (fileAlreadyExistsException: FileAlreadyExistsException) {
                logger.error("file $fileName has already exists,can't create repeat")
                isCreate = false;
            } catch (securityException: SecurityException) {
                logger.error("file $fileName has no power to create")
                isCreate = false;
            } catch (ex: Exception) {
                logger.error("unknow Exception when create a file :$fileName")
                isCreate = false;
            }
            return isCreate;
        }

        fun createFilesIfAllNoExists(fileNames: Array<String>): Map<String, Boolean> {
            val createSuccessMap: MutableMap<String, Boolean> = HashMap<String, Boolean>(fileNames.size);
            for (fileName in fileNames) {
                createSuccessMap.put(fileName, createFileIfNoExists(fileName))
            }
            return createSuccessMap;
        }

        fun writeFile(fileName: String, content: String): Boolean {
            return writeFile(fileName, content.toByteArray())
        }

        fun writeFile(fileName: String, content: ByteArray): Boolean {
            var isWriteSuccess: Boolean = true;
            try {
                java.nio.file.Files.write(java.nio.file.Paths.get(fileName), content);
            } catch (securityException: SecurityException) {
                logger.error("write file $fileName securityException")
                isWriteSuccess = false
            } catch (unsupportedOperationException: UnsupportedOperationException) {
                logger.error("write file $fileName unsupportedOperationException")
                isWriteSuccess = false
            } catch (ioException: IOException) {
                logger.error("write file $fileName ioException")
                isWriteSuccess = false
            } catch (ex: Exception) {
                logger.error("write file $fileName unKnow exception")
                isWriteSuccess = false
            }
            return isWriteSuccess;
        }

        fun writeFiles(fileNames: Array<String>, content: String): MutableMap<String, Boolean> {
            val writeSuccessMap: MutableMap<String, Boolean> = HashMap<String, Boolean>(fileNames.size);
            for (fileName in fileNames) {
                writeSuccessMap.put(fileName, writeFile(fileName, content));
            }
            return writeSuccessMap;
        }

        fun writeFiles(fileNames: Array<String>, content: ByteArray): MutableMap<String, Boolean> {
            val writeSuccessMap: MutableMap<String, Boolean> = HashMap<String, Boolean>(fileNames.size);
            for (fileName in fileNames) {
                writeSuccessMap.put(fileName, writeFile(fileName, content));
            }
            return writeSuccessMap;
        }

        fun writeFiles(fileAndContent: Map<String, String>): MutableMap<String, Boolean> {
            val writeSuccessMap: MutableMap<String, Boolean> = HashMap<String, Boolean>(fileAndContent.size);
            for ((fileName, content) in fileAndContent) {
                writeSuccessMap.put(fileName, writeFile(fileName, content));
            }
            return writeSuccessMap;
        }

        fun deleteFile(fileName: String): Boolean {
            var isDeleteSuccess: Boolean = true;
            try {
                java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(fileName));
            } catch (securityException: SecurityException) {
                logger.error("file $fileName delete false,security exception")
            } catch (ioException: IOException) {
                logger.error("file $fileName delete false,IO exception")
            } catch (ex: Exception) {
                logger.error("file $fileName delete false,unKnoe error")
            }
            return isDeleteSuccess;
        }

        fun deleteFiles(fileNames: Array<String>): MutableMap<String, Boolean> {
            var deleteSuccessMap: MutableMap<String, Boolean> = HashMap<String, Boolean>(fileNames.size);
            for (fileName in fileNames) {
                deleteSuccessMap.put(fileName, deleteFile(fileName))
            }
            return deleteSuccessMap;
        }
    }
}