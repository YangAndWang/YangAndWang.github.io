package com.learnwy.spring.boot.demo.mvn.controllers

import com.learnwy.spring.boot.demo.mvn.base.storage.FileSystemStorageService
import com.learnwy.spring.boot.demo.mvn.base.storage.StorageFileNotFoundException
import java.io.IOException
import java.util.stream.Collectors

import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.support.RedirectAttributes


import com.learnwy.spring.boot.demo.mvn.base.storage.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class FileUploadController {
    @Autowired
    private lateinit var storageService: StorageService

    @GetMapping(path = arrayOf("/uploadForm.html"))
    @Throws(IOException::class)
    fun listUploadedFiles(model: Model): String {
        model.addAttribute("files", storageService.loadAll().map(
                { path ->
                    MvcUriComponentsBuilder.fromMethodName(FileUploadController::class.java,
                            "serveFile", path.getFileName().toString()).build().toString()
                })
                .collect(Collectors.toList()))
        return "uploadForm.html"
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    fun serveFile(@PathVariable filename: String): ResponseEntity<Resource> {

        val file = storageService.loadAsResource(filename)
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file)
    }

    @PostMapping("/upload")
    fun handleFileUpload(@RequestParam("file") file: MultipartFile,
                         redirectAttributes: RedirectAttributes): String {

        storageService.store(file)
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.originalFilename + "!")

        return "redirect:/uploadForm.html"
    }

    @ExceptionHandler(StorageFileNotFoundException::class)
    fun handleStorageFileNotFound(exc: StorageFileNotFoundException): ResponseEntity<*> {
        return ResponseEntity.notFound().build<Any>()
    }

}