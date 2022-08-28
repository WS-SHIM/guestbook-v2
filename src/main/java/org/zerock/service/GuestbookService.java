package org.zerock.service;

import org.zerock.dto.GuestbookDTO;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
}
