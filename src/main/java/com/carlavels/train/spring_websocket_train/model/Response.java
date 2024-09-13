package com.carlavels.train.spring_websocket_train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {
    
    private String caseId;
    private String message;

}
