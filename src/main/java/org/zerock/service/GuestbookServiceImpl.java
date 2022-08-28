package org.zerock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.zerock.dto.GuestbookDTO;
import org.zerock.entity.Guestbook;
import org.zerock.repository.GuestbookRepository;


@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl  implements GuestbookService {

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO----------------");
        log.info(dto);
        Guestbook entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);
        return entity.getGno();
    }

    @Override
    public Long register2(GuestbookDTO dto) {
        log.info("DTO----------------");
        log.info(dto);
        Guestbook entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);
        return entity.getGno();
    }
}
