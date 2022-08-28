package org.zerock.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.dto.GuestbookDTO;
import org.zerock.entity.Guestbook;
import org.zerock.repository.GuestbookRepository;

import java.util.Optional;

@SpringBootTest
public class GuestbookServiceTests {
    @Autowired
    private GuestbookService service;
    @Autowired
    private GuestbookRepository guestbookRepository;

    @DisplayName("신규 게시물 등록 테스트")
    @Test
    public void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title....")
                .content("Sample content...")
                .writer("user0")
                .build();

        Long gno = service.register(guestbookDTO);

        Optional<Guestbook> byId = guestbookRepository.findById(gno);
        Guestbook guestbook = byId.get();

        Assertions.assertEquals(guestbookDTO.getContent(), guestbook.getContent());
        Assertions.assertEquals(guestbookDTO.getTitle(), guestbook.getTitle());
        Assertions.assertEquals(guestbookDTO.getWriter(), guestbook.getWriter());

    }

}
