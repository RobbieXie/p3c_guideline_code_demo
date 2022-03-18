package javaguideline.part1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class NameGuideline9 {

    public static void main(String[] args) throws JsonProcessingException {
        Record record = Record.builder()
                .isDeleted(true)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        Gson gson = new Gson();

        System.out.println(objectMapper.writeValueAsString(record));
        System.out.println(gson.toJson(record));

    }

    @Data
    @Builder
    public static class Record {
        private boolean isDeleted;
    }
}
