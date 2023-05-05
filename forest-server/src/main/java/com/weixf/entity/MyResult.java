package com.weixf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyResult {

    private Integer id;
    private String username;
    private String password;
}
