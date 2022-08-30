package org.zerock.service;

import org.zerock.dto.GuestbookDTO;
import org.zerock.dto.PageRequestDTO;
import org.zerock.dto.PageResultDTO;
import org.zerock.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    default Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity) {
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

    Long register2(GuestbookDTO guestbookDTO);
}
