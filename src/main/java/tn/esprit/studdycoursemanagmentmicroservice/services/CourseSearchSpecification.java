package tn.esprit.studdycoursemanagmentmicroservice.services;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;

import java.util.List;
import java.util.Objects;

public class CourseSearchSpecification {

    public static Specification<Course> categoryIdIn(List<Long> categoryIds) {
        return (root, query, builder) ->
                CollectionUtils.isEmpty(categoryIds) ?
                        builder.conjunction() :
                        root.get("category").get("id").in(categoryIds);
    }

    public static Specification<Course> levelIn(List<String> levels) {
        return (root, query, builder) ->
                CollectionUtils.isEmpty(levels) ?
                        builder.conjunction() :
                        root.get("level").in(levels);
    }

    public static Specification<Course> titleOrDescriptionLike(String searchQuery) {
        return (root, query, builder) ->
                StringUtils.isEmpty(searchQuery) ?
                        builder.conjunction() :
                        builder.or(
                                builder.like(root.get("title"), "%" + searchQuery + "%"),
                                builder.like(root.get("description"), "%" + searchQuery + "%")
                        );
    }

    public static Specification<Course> enrolledUser(Integer userId) {
        return (root, query, builder) ->
                Objects.isNull(userId) ?
                        builder.conjunction() :
                        builder.equal(root.get("enrollments").get("user").get("id"), userId);
    }

}
