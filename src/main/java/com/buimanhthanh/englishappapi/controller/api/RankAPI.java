package com.buimanhthanh.englishappapi.controller.api;

import com.buimanhthanh.englishappapi.dto.RankDTO;
import com.buimanhthanh.englishappapi.dto.ResponseObject;
import com.buimanhthanh.englishappapi.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rank")
public class RankAPI {
    @Autowired
    private RankService rankService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> loadAllTopic() {
        List<RankDTO> ranks = rankService.findAll().get();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query ranks success", ranks.size() == 0 ? "" : ranks)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> loadOneTopic(@PathVariable Integer id) {
        Optional<RankDTO> rankDTOOptional = rankService.findOne(id);
        return rankDTOOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query rank success", rankDTOOptional.get())
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Can not found rank with id : " + id, "")
                );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> addTopic(@RequestBody RankDTO rankDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert rank success", rankService.saveOrUpdate(rankDTO))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateTopic(@PathVariable Integer id, @RequestBody RankDTO rankDTO) {
        Optional<RankDTO> rankDTOOptional = rankService.findOne(id);
        return rankDTOOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Update rank success", rankService.saveOrUpdate(rankDTO))
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot found rank with id : " + id, false)
                );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteTopic(@PathVariable Integer id) {
        rankService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Delete rank success", true)
        );
    }
}
