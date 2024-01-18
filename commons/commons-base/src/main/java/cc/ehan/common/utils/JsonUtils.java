package cc.ehan.common.utils;

import cc.ehan.common.constant.DateFormatStandard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.*;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * json工具类
 */
public class JsonUtils {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateFormatStandard.DATE_TIME_FORMATTER));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateFormatStandard.DATE_FORMATTER));
        module.addSerializer(YearMonth.class, new YearMonthSerializer(DateFormatStandard.YEAR_MONTH_FORMATTER));
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(DateFormatStandard.TIME_FORMATTER));
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        module.addSerializer(OffsetDateTime.class, OffsetDateTimeSerializer.INSTANCE);
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateFormatStandard.DATE_TIME_FORMATTER));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateFormatStandard.DATE_FORMATTER));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateFormatStandard.TIME_FORMATTER));
        module.addDeserializer(YearMonth.class, new YearMonthDeserializer(DateFormatStandard.YEAR_MONTH_FORMATTER));

        OBJECT_MAPPER.setTimeZone(TimeZone.getDefault())
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(module);
    }

    public static String toString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toFormatJson(Object object) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(String value, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.readValue(value, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(TreeNode jsonNode, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.treeToValue(jsonNode, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends JsonNode> T toTreeNode(Object value) {
        T jsonNode = OBJECT_MAPPER.valueToTree(value);
        return jsonNode;
    }

    public static <T> T toObject(String value, TypeReference<T> typeReference) {
        try {
            return OBJECT_MAPPER.readValue(value, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> toList(ArrayNode arrayNode, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try {
            for (JsonNode jsonNode : arrayNode) {
                T t = OBJECT_MAPPER.treeToValue(jsonNode, tClass);
                list.add(t);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
