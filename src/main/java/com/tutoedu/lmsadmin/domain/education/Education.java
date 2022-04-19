package com.tutoedu.lmsadmin.domain.education;

import lombok.Data;

import java.time.LocalDate;

/**
 * 과정 entity
 * */
@Data
public class Education {

    private int eduId;                      //과정 고유 번호
    private String eduNm;                   //과정명
    private String eduDesc;                 //과정 상세 설명
    private String thumImgUrl;              //섬네일 이미지 주소
    private LocalDate enrollStartDate;      //등록 시간 일자
    private LocalDate enrollEndDate;        //등록 마감 일자
    private LocalDate eduStartDate;         //과정 시작 일자
    private LocalDate eduEndDate;           //과정 종료 일자
    private int capacity;                   //정원
    private int eduCtgy;                    //과정 카테고리 ( 1 : , 2 : , 3 : )

    private int tutrId;                     //교사 고유 번호
    private int[] payments;                 //결제 수단 ( 0 : 무료강의, 1 : 무통장, 2 : 신용카드, 3: 현장 결제 )

}
