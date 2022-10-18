package com.buimanhthanh.englishappapi.controller.api;

import com.buimanhthanh.englishappapi.dto.ResponseObject;
import com.buimanhthanh.englishappapi.dto.VocabularyDTO;
import com.buimanhthanh.englishappapi.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vocabulary")
public class VocabularyAPI {
    @Autowired
    private VocabularyService vocabularyService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> loadAllVocabulary() {
        List<VocabularyDTO> vocabularies = vocabularyService.findAll().get();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query vocabularies success", vocabularies.size() == 0 ? "" : vocabularies)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> loadOneVocabulary(@PathVariable Integer id) {
        Optional<VocabularyDTO> vocabularyOptional = vocabularyService.findOne(id);
        return vocabularyOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query vocabulary success", vocabularyOptional.get())
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Can not found vocabulary with id : " + id, "")
                );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> addVocabulary(@RequestBody VocabularyDTO vocabularyDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert vocabulary success", vocabularyService.saveOrUpdate(vocabularyDTO))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateVocabulary(@PathVariable Integer id, @RequestBody VocabularyDTO vocabularyDTO) {
        Optional<VocabularyDTO> vocabularyOptional = vocabularyService.findOne(id);
        return vocabularyOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Update vocabulary success", vocabularyService.saveOrUpdate(vocabularyDTO))
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot found vocabulary with id : " + id, false)
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteVocabulary(@PathVariable Integer id) {
        vocabularyService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Delete vocabulary success", true)
        );
    }
}
