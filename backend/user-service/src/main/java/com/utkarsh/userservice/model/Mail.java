package com.utkarsh.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    @NotNull
    private String sender;

    @NotNull
    private String receiver;

    private String subject;
    private String content;
    private String sentMailDate;

}
