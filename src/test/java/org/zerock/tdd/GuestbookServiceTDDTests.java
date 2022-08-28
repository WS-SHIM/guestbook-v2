package org.zerock.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.dto.GuestbookDTO;
import org.zerock.entity.Guestbook;
import org.zerock.repository.GuestbookRepository;
import org.zerock.service.GuestbookService;

import java.util.Optional;

@SpringBootTest
public class GuestbookServiceTDDTests {

    @Autowired
    private GuestbookService service;
    @Autowired
    private GuestbookRepository guestbookRepository;


    @Test
    public void registerTDDTest(){
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title....")
                .content("Sample content...")
                .writer("user0")
                .build();

        Long gno = service.register2(guestbookDTO);

        Optional<Guestbook> byId = guestbookRepository.findById(gno);
        Guestbook guestbook = byId.get();

        Assertions.assertEquals(guestbookDTO.getContent(), guestbook.getContent());
        Assertions.assertEquals(guestbookDTO.getTitle(), guestbook.getTitle());
        Assertions.assertEquals(guestbookDTO.getWriter(), guestbook.getWriter());

    }

}
