package org.zerock.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.entity.Guestbook;
import org.zerock.entity.QGuestbook;

import java.util.Optional;

@SpringBootTest
public class GuestbookRepositoryTest {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void test(){
        System.out.println("######################");
        Assertions.assertEquals(1,2);
    }

    @Test
    public void testQuery1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
        QGuestbook qGuestbook = QGuestbook.guestbook; //1
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();  //2
        BooleanExpression expression = qGuestbook.title.contains(keyword); //3
        builder.and(expression); //4
        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable); //5
        result.stream().forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }

    @Test
    @DisplayName("컨텐츠 등록 테스트")
    @Transactional
    public void saveTest() {
        Guestbook guestbook = Guestbook.builder()
                .title("TEST")
                .content("TEST CONTENT")
                .writer("USER")
                .build();
        Guestbook save = guestbookRepository.save(guestbook);
        Optional<Guestbook> byId = guestbookRepository.findById(save.getGno());
        Assertions.assertEquals(save.getContent(),byId.get().getContent());
    }
}
