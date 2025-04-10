package tn.esprit.studdycoursemanagmentmicroservice.utils;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {
    private static final String SEPARATOR = "-|-";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return Objects.nonNull(stringList) ? String.join(SEPARATOR, stringList) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return StringUtils.isNotBlank(string) ? Arrays.asList(string.split(SEPARATOR)) : emptyList();
    }
}