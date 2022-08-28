package org.zerock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.entity.Guestbook;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO {
    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public Guestbook converToEntity() {
        Guestbook entity = Guestbook.builder()
                .gno(this.gno)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();
        return entity;
    }
}
