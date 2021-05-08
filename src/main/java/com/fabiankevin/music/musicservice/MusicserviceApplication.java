package com.fabiankevin.music.musicservice;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RestController
public class MusicserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicserviceApplication.class, args);
    }

    @GetMapping
    public List<Music> getMusics(){
        Random r = new Random();
        return Arrays.asList(
                Music.builder()
                        .album("BLUE")
                        .id(r.nextLong())
                        .genre("ROCK")
                        .title("Million Dollar's Houses")
                        .build()
        );
    }

}

@Data
@Builder
class Music {
    private Long id;
    private String genre;
    private String title;
    private String album;
}