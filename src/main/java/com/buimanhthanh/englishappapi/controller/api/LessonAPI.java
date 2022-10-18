package com.buimanhthanh.englishappapi.controller.api;

import com.buimanhthanh.englishappapi.dto.LessonDTO;
import com.buimanhthanh.englishappapi.dto.ResponseObject;
import com.buimanhthanh.englishappapi.entity.Lesson;
import com.buimanhthanh.englishappapi.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lesson")
public class LessonAPI {
    @Autowired
    private LessonService lessonService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> loadAllLesson() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query lesson success", lessonService.findAll().get())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> loadOneLesson(@PathVariable Integer id) {
        Optional<LessonDTO> lessonOptional = lessonService.findOne(id);
        return lessonOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query lesson success", lessonOptional.get())
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Can not found lesson with id : " + id, "")
                );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> addLesson(@RequestBody Lesson lesson) {
        lesson.setId(null);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert lesson success", lessonService.saveOrUpdate(lesson))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateLesson(@RequestBody Lesson lesson, @PathVariable Integer id) {
        Optional<LessonDTO> lessonOptional = lessonService.findOne(id);
        return lessonOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Update lesson success", lessonService.saveOrUpdate(lesson))
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Can not found lesson with id " + id, false)
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteLesson(@PathVariable Integer id) {
        lessonService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "delete lesson success", true)
        );
    }
}
