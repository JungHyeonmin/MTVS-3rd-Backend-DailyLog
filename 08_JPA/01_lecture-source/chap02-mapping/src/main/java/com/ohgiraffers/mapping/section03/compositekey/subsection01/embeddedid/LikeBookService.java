package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import org.springframework.stereotype.Service;

@Service
public class LikeBookService {

    private LikeRepository likeRepository;

    public LikeBookService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public void generateLikeBook(LikeBookRequestDTO likeInfo) {
// 엔티티 만들기
        Like like = new Like(
                new LikeCompositeKey(
                        new LikedMemberNo(likeInfo.getLikedMemberNo()),
                        new LikedBookNo(likeInfo.getLikedBookNo())
                )
        );
// 리포지토리를 통해서 저장
        likeRepository.save(like);
    }
}