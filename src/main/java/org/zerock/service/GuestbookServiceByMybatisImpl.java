package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.dto.GuestbookDTO;
import org.zerock.dto.PageRequestDTO;
import org.zerock.dto.PageResultDTO;
import org.zerock.entity.Guestbook;

//@Service
@Log4j2
public class GuestbookServiceByMybatisImpl implements GuestbookService {

    @Override
    public Long register(GuestbookDTO dto) {
        return null;
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        return null;
    }

    @Override
    public Long register2(GuestbookDTO guestbookDTO) {
        return null;
    }
}
