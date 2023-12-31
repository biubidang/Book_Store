package com.sqlwork.book_store.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBuyingVo {

        private Long id;

        private String isbn;

        private String name;

        private Float prize;

        private Integer num;
    }


