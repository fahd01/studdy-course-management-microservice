package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.ModuleCompletion;

import java.util.List;

@Repository
public interface ModuleCompletionRepository extends JpaRepository<ModuleCompletion, Long> {

    //@Query("SELECT Module FROM ModuleCompletion mc WHERE mc.user.id = :userId AND mc.module.course.id = :courseId AND mc.completed = true")
    //List<Module> findCompletedModules(Long userId, Long courseId);

    @Query("SELECT COUNT(mc) FROM ModuleCompletion mc WHERE mc.user.id = :userId AND mc.module.course.id = :courseId AND mc.completed = true")
    int countCompletedModules(@Param("userId") Long userId, @Param("courseId") Long courseId);

    List<ModuleCompletion> getModuleCompletionsByModuleIdAndUserId(Long moduleId, Long userId);

    @Query("SELECT mc FROM ModuleCompletion mc " +
            "WHERE mc.user.id = :userId " +
            "AND mc.module.course.id = :courseId")
    List<ModuleCompletion> findByUserIdAndCourseId(@Param("userId") Long userId,
                                                   @Param("courseId") Long courseId);

}
